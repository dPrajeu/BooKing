package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/hotelshaveroomsdb")
public class HotelHasRoomsController {
    HotelHasRoomsService hotelHasRoomsService;

    //list all hotels
    //http://localhost:8080/front_page/hotelshaveroomsdb/all_hotels
    @RequestMapping(value = "/all_hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelHasRoomsEntity> getAllHotels() {
        return hotelHasRoomsService.returnAll();
    }
}
