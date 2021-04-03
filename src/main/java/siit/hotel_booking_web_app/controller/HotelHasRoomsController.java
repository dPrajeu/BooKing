package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/hotelshaveroomsdb")
public class HotelHasRoomsController {
    private final HotelHasRoomsService hotelHasRoomsService;
    private final HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;

    //list all entries
    //http://localhost:8080/front_page/hotelshaveroomsdb/all_hotels
    @RequestMapping(value = "/all_hotels", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<HotelHasRoomsRequestDto> getAllHotels() {
//        return hotelHasRoomsService.returnAll();
//    }
    public Map<String,List<HotelHasRoomsRequestDto>> getAllHotels() {
        return hotelHasRoomsService.returnAll();
    }


    //list by Hotel Id
    //http://localhost:8080/front_page/hotelshaveroomsdb/by_hotelId
    @RequestMapping(value = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelHasRoomsRequestDto> getHotelHasRoomsByHotelId(@RequestParam(name = "hotelId") Integer hotelId) {

        return hotelHasRoomsService.findByHotelId(hotelId);
    }
}