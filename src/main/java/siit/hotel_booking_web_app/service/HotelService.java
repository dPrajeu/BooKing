package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.mapper.hotel.HotelNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.repository.HotelRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Configurable
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelNttToDtoMapper hotelNttToDtoMapper;

    public List<HotelRequestDto> returnAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelEntity -> hotelNttToDtoMapper.mapNttToDto(hotelEntity))
                .collect(toList());
    }

    public HotelRequestDto hotelById(Integer hotelId) {
        return hotelNttToDtoMapper.mapNttToDto(hotelRepository.findById(hotelId).orElseThrow());

    }
}
