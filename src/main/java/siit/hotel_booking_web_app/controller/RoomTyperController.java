package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.mapper.hotelHasRooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;
import siit.hotel_booking_web_app.service.RoomTypeService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/roomtypesdb")
public class RoomTyperController {
    private final HotelHasRoomsService hotelHasRoomsService;
    private final HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;
    private final RoomTypeService roomTypeService;

    //list all entries
    //http://localhost:8080/front_page/roomtypesdb/all_room_types
    @RequestMapping(value = "/all_room_types", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomTypeEntity> getAllRooms() {
        return roomTypeService.returnAll();
    }
}
