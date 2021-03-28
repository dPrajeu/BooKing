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
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelUpdateDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;

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

    public List<HotelRequestDto> returnAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }

    public HotelRequestDto hotelById(Integer hotelId) {
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
        return hotelNttToDtoMapper.createNTTfromDTO(saveHotelNtt);
    }

    @Transactional
    public HotelRequestDto updateHotelNtt(HotelUpdateDto hotelUpdateDto) {
        Optional<HotelEntity> byId = hotelRepository.findById(hotelUpdateDto.getHotelId());
        HotelEntity hotelEntity = byId.orElseThrow(() -> new HotelNotFoundException("No customer was found for the given ID: " + hotelUpdateDto.getHotelId()));

        hotelEntity.setHotelName(hotelUpdateDto.getHotelName());
        hotelEntity.setPhoneNumber(hotelUpdateDto.getPhoneNumber());
        hotelEntity.setHotelEmail(hotelUpdateDto.getHotelEmail());
        hotelEntity.setCountry(hotelUpdateDto.getCountry());
        hotelEntity.setCity(hotelUpdateDto.getCity());
        hotelEntity.setAddress(hotelUpdateDto.getAddress());
        hotelEntity.setRating(hotelUpdateDto.getRating());


//        ExampleMatcher customerMatcher = ExampleMatcher.matchingAny()
//                .withMatcher("customerId", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("socialId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//
//        Example <CustomerEntity> result  = Example.of(customerEntity,customerMatcher);

        return hotelNttToDtoMapper.mapNttToDto(hotelEntity);

    }

    public void deleteHotelById(Integer hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
