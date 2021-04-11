package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siit.hotel_booking_web_app.exceptions.hotel.HotelNotFoundException;
import siit.hotel_booking_web_app.mapper.hotel.HotelDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.hotel.HotelNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestWithFilteredRoomDetailsDTO;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelUpdateDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;
import siit.hotel_booking_web_app.repository.RoomTypeRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Configurable
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelNttToDtoMapper hotelNttToDtoMapper;
    private final HotelDtoToNttMapper hotelDtoToNttMapper;
    private final HotelHasRoomsRepository hotelHasRoomsRepository;
    private final RoomTypeRepository roomTypeRepository;


    public List<HotelRequestDto> returnAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }

    public HotelRequestWithFilteredRoomDetailsDTO hotelById(Integer hotelId) {
        return hotelNttToDtoMapper.mapNttToDtoSecond(hotelRepository.findById(hotelId).orElseThrow());

    }

    public HotelRequestDto hotelWithAllDetailsById(Integer hotelId) {
        return hotelNttToDtoMapper.mapNttToDto(hotelRepository.findById(hotelId).orElseThrow());
    }

    public List<HotelRequestDto> returnAllByCountry(String country) {
        return hotelRepository.findAllByCountry(country)
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }


    public List<HotelRequestDto> returnAllByCity(String city) {
        return hotelRepository.findAllByCity(city)
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }

    public List<HotelRequestDto> returnAllByRating(Integer rating) {
        return hotelRepository.findAllByRating(rating)
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }

    public HotelCreateDto createHotelNtt(HotelCreateDto hotelCreateDto) {
        HotelEntity mappedHotelNtt = hotelDtoToNttMapper.mapNttToDto(hotelCreateDto);
        HotelEntity saveHotelNtt = hotelRepository.save(mappedHotelNtt);

        hotelCreateDto.getHotelHasRoomsEntitiesList().stream()
                .map(h -> HotelHasRoomsEntity.builder()
                        .hotelWithRooms(HotelHasRoomCompositPK.builder()
                                .hotelId(saveHotelNtt.getHotelId())
                                .roomType(h.getHotelWithRooms().getRoomType())
                                .build())
                        .hotelId(saveHotelNtt)
                        .roomType(roomTypeRepository.getOne(h.getHotelWithRooms().getRoomType()))
                        .roomQuantity(h.getRoomQuantity())
                        .pricePerNight(h.getPricePerNight())
                        .build())
                .collect(toList())
                .forEach(hotelHasRoomsRepository::save);

        return hotelNttToDtoMapper.createDTOfromNtt(saveHotelNtt);
    }

    @Transactional
    public HotelRequestDto updateHotelNtt(HotelUpdateDto hotelUpdateDto) {
        Optional<HotelEntity> byId = hotelRepository.findById(hotelUpdateDto.getHotelId());
        HotelEntity hotelEntity = byId.orElseThrow(() -> new HotelNotFoundException("No hotel was found for the given ID: " + hotelUpdateDto.getHotelId()));

        hotelEntity.setHotelName(hotelUpdateDto.getHotelName());
        hotelEntity.setPhoneNumber(hotelUpdateDto.getPhoneNumber());
        hotelEntity.setHotelEmail(hotelUpdateDto.getHotelEmail());
        hotelEntity.setCountry(hotelUpdateDto.getCountry());
        hotelEntity.setCity(hotelUpdateDto.getCity());
        hotelEntity.setAddress(hotelUpdateDto.getAddress());
        hotelEntity.setRating(hotelUpdateDto.getRating());

        return hotelNttToDtoMapper.mapNttToDto(hotelEntity);

    }

    public void deleteHotelById(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
