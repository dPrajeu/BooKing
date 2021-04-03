package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelUpdateDto;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public Map<String, List<HotelHasRoomsRequestDto>> getAllHotels() {
        return hotelHasRoomsService.returnAll();
    }


    //list by Hotel Id
    //http://localhost:8080/front_page/hotelshaveroomsdb/by_hotelId
    @RequestMapping(value = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelHasRoomsRequestDto> getHotelHasRoomsByHotelId(@RequestParam(name = "hotelId") Integer hotelId) {

        return hotelHasRoomsService.findByHotelId(hotelId);
    }

    //update hotel room quantity
    //http://localhost:8080/front_page/hotelshaveroomsdb/update_hotel_rooms_info/{hotelId}
//    @PutMapping(value = "/update_hotel_rooms_info/{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<HotelHasRoomsRequestDto> updateHotelRoomsInfo(@PathVariable(name = "hotelId") Integer hotelId, @RequestBody @Valid @NotNull HotelHasRoomsRequestDto hotelHasRoomsRequestDto) {
//        hotelHasRoomsRequestDto.setHotelId(hotelId);
//        return hotelHasRoomsService.updateHotelRoomsDetailsNTT(hotelHasRoomsRequestDto);
//    }
}