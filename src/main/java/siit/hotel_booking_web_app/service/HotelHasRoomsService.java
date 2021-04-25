package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsUpdateDTO;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;
import siit.hotel_booking_web_app.repository.RoomTypeRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Slf4j
@Service
@Configurable
@RequiredArgsConstructor
public class HotelHasRoomsService {
    private final HotelHasRoomsRepository hotelHasRoomsRepository;
    private final HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;
    private final HotelRepository hotelRepository;

    public Map<String, List<HotelHasRoomsRequestDto>> returnAll() {
        return hotelHasRoomsRepository.findAll()
                .stream()
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
                .collect(groupingBy(HotelHasRoomsRequestDto::getHotelName));

    }

    public List<HotelHasRoomsRequestDto> findByHotelId(Integer hotelId) {
        HotelEntity hotelEntity = hotelRepository.findById(hotelId).orElseThrow();

        return hotelHasRoomsRepository.findAllByHotelId(hotelEntity)
                .stream()
                .map(hotelHasRoomsEntity -> hotelHasRoomsNttToDtoMapper.mapNttToDto(hotelHasRoomsEntity))
                .collect(toList());
    }

    public List<HotelHasRoomsEntity> findByRoomType(Integer roomType) {
        return hotelHasRoomsRepository.findByRoomType(roomType);
    }

    public HotelHasRoomsEntity getByHotelAndRoom(Integer hotelId, Integer roomType) {

        return hotelHasRoomsRepository.findById(new HotelHasRoomCompositPK(hotelId, roomType)).orElseThrow();

    }

    @Transactional
    public void updateHotelRoomsDetails(Integer hotelId, Integer roomType, HotelHasRoomsUpdateDTO hotelHasRoomsUpdateDTO) {

        HotelHasRoomsEntity hotelHasRoomsEntity = hotelHasRoomsRepository.findById(new HotelHasRoomCompositPK(hotelId, roomType)).orElseThrow();
        hotelHasRoomsEntity.setRoomQuantity(hotelHasRoomsUpdateDTO.getRoomQuantity());
        hotelHasRoomsEntity.setPricePerNight(hotelHasRoomsUpdateDTO.getPricePerNight());
        hotelHasRoomsRepository.save(hotelHasRoomsEntity);
    }
}
