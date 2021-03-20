package siit.hotel_booking_web_app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelUpdateDto;
import siit.hotel_booking_web_app.service.HotelService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/hotelsdb")
public class HotelController {

    private final HotelService hotelService;


    //list all hotels
    //http://localhost:8080/front_page/hotelsdb/all_hotels
    @RequestMapping(value = "/all_hotels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getAllHotels() {
        return hotelService.returnAll();
    }

    //list hotel details based on ID
    //http://localhost:8080/front_page/hotelsdb/hotelId=?hotelId=1
    @RequestMapping(value = "/hotelId={hotelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelRequestDto getHotelById(@RequestParam(name = "hotelId") Integer hotelId) {
        return hotelService.hotelById(hotelId);
    }

    //list hotels based on a given country
    //http://localhost:8080/front_page/hotelsdb/hotel_country=?country=china
    @RequestMapping(value = "/hotel_country={country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByCountry(@RequestParam(name = "country") String country) {
        return hotelService.returnAllByCountry(country);
    }


    //list hotels based on a given city
    //http://localhost:8080/front_page/hotelsdb/hotel_country_city=?city=Gaobu
    @RequestMapping(value = "/hotel_country_city={city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByCity(@RequestParam(name = "city") String city) {
        return hotelService.returnAllByCity(city);
    }

    //list hotels based on rating
    //http://localhost:8080/front_page/hotelsdb/hotel_rating=?rating=5
    @RequestMapping(value = "/hotel_rating={rating}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByRating(@RequestParam(name = "rating") Integer rating) {
        return hotelService.returnAllByRating(rating);
    }

    //create a new hotel
    //http://localhost:8080/front_page/hotelsdb/add_new_hotel
    //    {
    //        "hotelName": "Hilton",
    //            "phoneNumber": "+40 47645551",
    //            "hotelEmail": "hilton@hilton.ro",
    //            "country": "Romania",
    //            "city": "Bucuresti",
    //            "address": "Panselutelor 56",
    //            "rating": 5
    //    }
    @PutMapping(value = "/add_new_hotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelCreateDto addANewHotelFromInput(@RequestBody HotelCreateDto hotelCreateDto) {
        return hotelService.createHotelNtt(hotelCreateDto);
    }

    //update a hotel data by ID
    //http://localhost:8080/front_page/hotelsdb/update33
    @PutMapping(value = "/update{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelRequestDto updateHotelDetails(@PathVariable(name = "hotelId") Integer hotelId,
                                              @RequestBody @Valid HotelUpdateDto hotelUpdateDto) {
        hotelUpdateDto.setHotelId(hotelId);
        return hotelService.updateHotelNtt(hotelUpdateDto);
    }

    //delete a hotel by ID
    //http://localhost:8080/front_page/hotelsdb/delete?hotelId=33
    @DeleteMapping(value = "/delete{hotelId}")
    public void deleteHotelById(Integer hotelId) {
        hotelService.deleteHotelById(hotelId);
    }


}
