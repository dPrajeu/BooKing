package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Configurable
@RequiredArgsConstructor
public class HotelHasRoomsService {
    private final HotelHasRoomsRepository hotelHasRoomsRepository;
    private final HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;

    public List<HotelHasRoomsRequestDto> returnAll() {
        return hotelHasRoomsRepository.findAll()
                .stream()
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
                .collect(toList());
    }


    public List<HotelHasRoomsRequestDto> findByHotelId(Integer hotelId) {
        return hotelHasRoomsRepository.findByHotelId(hotelId)
                .stream()
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
                .collect(toList());
    }
}
