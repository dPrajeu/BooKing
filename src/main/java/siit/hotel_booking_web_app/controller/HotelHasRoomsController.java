package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import siit.hotel_booking_web_app.mapper.hotel_has_rooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto.HotelHasRoomsUpdateDTO;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    public Map<String, List<HotelHasRoomsRequestDto>> getAllHotels() {
        return hotelHasRoomsService.returnAll();
    }


    //list by Hotel Id
    //http://localhost:8080/front_page/hotelshaveroomsdb/by_hotelId/
    @RequestMapping(value = "/by_hotelId/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelHasRoomsRequestDto> getHotelHasRoomsByHotelId(@RequestParam(name = "hotelId") Integer hotelId) {
        return hotelHasRoomsService.findByHotelId(hotelId);
    }


    //    list by hotelId and roomType
    //http://localhost:8080/front_page/hotelshaveroomsdb/by_hotelId_and_roomType/
    @RequestMapping(value = "/by_hotelId_and_roomType/", produces = MediaType.APPLICATION_JSON_VALUE)
    public HotelHasRoomsEntity getByRoomAndHotel(@RequestParam(name = "hotelId") Integer hotelId, @RequestParam(name = "roomType") Integer roomType) {
        return hotelHasRoomsService.getByHotelAndRoom(hotelId, roomType);

    }

    //list by room type
    //http://localhost:8080/front_page/hotelshaveroomsdb/list_hotels_by_roomType/
    @RequestMapping(value = "/list_hotels_by_roomType/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelHasRoomsEntity> getHotelHasRoomsByRoomType(@RequestParam(name = "roomType") Integer roomType) {

        return hotelHasRoomsService.findByRoomType(roomType);
    }

    //update hotel room quantity and Price
    //http://localhost:8080/front_page/hotelshaveroomsdb/update_hotel_rooms_info/
    @PutMapping(value = "/update_hotel_rooms_info/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateHotelRoomsInfo(@RequestParam(name = "hotelId") Integer hotelId, @RequestParam(name = "roomType") Integer roomType, @RequestBody @Valid @NotNull HotelHasRoomsUpdateDTO hotelHasRoomsUpdateDTO) {
        hotelHasRoomsService.updateHotelRoomsDetails(hotelId, roomType, hotelHasRoomsUpdateDTO);
    }


}