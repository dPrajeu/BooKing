package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;

import java.util.*;

import static java.util.stream.Collectors.*;

@Service
@Configurable
@RequiredArgsConstructor
public class HotelHasRoomsService {
    private final HotelHasRoomsRepository hotelHasRoomsRepository;
    private final HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;
    private final HotelRepository hotelRepository;


//        public List<HotelHasRoomsRequestDto> returnAll() {
//        return hotelHasRoomsRepository.findAll()
//                .stream()
//                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
//                .sorted(Comparator.comparing(HotelHasRoomsRequestDto::getHotelName))
//                .collect(toList());
//    }

    public Map<String, List<HotelHasRoomsRequestDto>> returnAll() {
        return hotelHasRoomsRepository.findAll()
                .stream()
//                .sorted(Comparator.comparing(h -> h.getHotelId().getHotelId()))
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
//                .sorted(Comparator.comparing(h -> h.getHotelName()))
                .collect(groupingBy(HotelHasRoomsRequestDto::getHotelName));

//      return unsortedMap.entrySet()
//              .stream()
//              .sorted(Comparator.comparing(h -> h.getKey()))
//              .

    }


    public List<HotelHasRoomsRequestDto> findByHotelId(Integer hotelId) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelId).orElseThrow();

        return hotelHasRoomsRepository.findByHotelId(hotelEntity)
                .stream()
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
//                .sorted(Comparator.comparing(HotelHasRoomsRequestDto::getHotelName))
                .collect(toList());
    }
}
