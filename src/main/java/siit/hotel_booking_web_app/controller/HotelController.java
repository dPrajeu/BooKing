package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestWithFilteredRoomDetailsDTO;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelUpdateDto;
import siit.hotel_booking_web_app.service.HotelService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public HotelRequestWithFilteredRoomDetailsDTO getHotelById(@RequestParam(name = "hotelId") Integer hotelId) {
        return hotelService.hotelById(hotelId);
    }

    //list hotel details based on ID
    //http://localhost:8080/front_page/hotelsdb/hotelWithAllDetails=?hotelId=1
    @RequestMapping(value = "/hotelWithAllDetails=", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelRequestDto getHotelWithAllDetailsById(@RequestParam(name = "hotelId") Integer hotelId) {
        return hotelService.hotelWithAllDetailsById(hotelId);
    }

    //list hotels based on a given country
    //http://localhost:8080/front_page/hotelsdb/hotel_country=?country=china
    @RequestMapping(value = "/hotel_country=", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByCountry(@RequestParam(name = "country") String country) {
        return hotelService.returnAllByCountry(country);
    }

    //list hotels based on a given city
    //http://localhost:8080/front_page/hotelsdb/hotel_country_city=?city=Gaobu
    @RequestMapping(value = "/hotel_country_city=", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByCity(@RequestParam(name = "city") String city) {
        return hotelService.returnAllByCity(city);
    }

    //list hotels based on rating
    //http://localhost:8080/front_page/hotelsdb/hotel_rating=?rating=5
    @RequestMapping(value = "/hotel_rating=", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelRequestDto> getHotelsByRating(@RequestParam(name = "rating") Integer rating) {
        return hotelService.returnAllByRating(rating);
    }

    //JSON entry to help test the add feature
    //create a new hotel
    //http://localhost:8080/front_page/hotelsdb/add_new_hotel
    //{
    //   "hotelName": "srerter",
    //        "phoneNumber": "5523421342329",
    //        "hotelEmail": "ro3242334@izo.com",
    //        "country": "Romania",
    //        "city": "Brasov",
    //        "address": "sad234ddm 232",
    //        "rating": 2,
    //   "hotelHasRoomsEntitiesList": [
    //        {
    //            "hotelWithRooms": {
    //                "roomType": 1
    //            },
    //            "roomQuantity": 38,
    //            "pricePerNight": 6.3
    //        },
    //        {
    //            "hotelWithRooms": {
    //                "roomType": 2
    //            },
    //            "roomQuantity": 47,
    //            "pricePerNight": 12.08
    //        },
    //        {
    //            "hotelWithRooms": {
    //                "roomType": 3
    //            },
    //            "roomQuantity": 22,
    //            "pricePerNight": 20.32
    //        },
    //        {
    //            "hotelWithRooms": {
    //                "roomType": 4
    //            },
    //            "roomQuantity": 22,
    //            "pricePerNight": 30.86
    //        },
    //        {
    //            "hotelWithRooms": {
    //                "roomType": 5
    //            },
    //            "roomQuantity": 44,
    //            "pricePerNight": 40.37
    //        }
    //    ]
    //}
    @PostMapping(value = "/add_new_hotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelCreateDto addANewHotelFromInput(@RequestBody HotelCreateDto hotelCreateDto) {
        return hotelService.createHotelNtt(hotelCreateDto);
    }

    //update a hotel data by ID
    //http://localhost:8080/front_page/hotelsdb/update33
    @PutMapping(value = "/update{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelRequestDto updateHotelDetails(@PathVariable(name = "hotelId") Integer hotelId,
                                              @RequestBody @Valid @NotNull HotelUpdateDto hotelUpdateDto) {
        hotelUpdateDto.setHotelId(hotelId);
        return hotelService.updateHotelNtt(hotelUpdateDto);
    }

    //delete a hotel by ID
    //http://localhost:8080/front_page/hotelsdb/delete?hotelId=33
    @DeleteMapping(value = "/delete")
    public void deleteHotelById(Integer hotelId) {
        hotelService.deleteHotelById(hotelId);
    }





//    //update a hotel data by ID
//    //http://localhost:8080/front_page/hotelsdb/update33
//    @PutMapping(value = "/update{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public HotelRequestDto updateHotelRooms(@PathVariable(name = "hotelId") Integer hotelId,
//                                              @RequestBody @Valid @NotNull HotelUpdateDto hotelUpdateDto) {
//        hotelUpdateDto.setHotelId(hotelId);
//        return hotelService.updateHotelNtt(hotelUpdateDto);
//    }

}
