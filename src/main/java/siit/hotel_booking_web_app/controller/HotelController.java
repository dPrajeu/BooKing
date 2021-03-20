package siit.hotel_booking_web_app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.service.HotelService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/hotelsdb")
public class HotelController {

    private final HotelService hotelService;


    //list all hotels
    //http://localhost:8080/front_page/hotelsdb/all_hotels
    @RequestMapping(value = "/all_hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getAllHotels(){
        return hotelService.returnAll();
    }

    @RequestMapping(value = "/{hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelRequestDto getHotelById(@RequestParam(name = "hotelId") Integer hotelId){
        return hotelService.hotelById(hotelId);
    }

}
