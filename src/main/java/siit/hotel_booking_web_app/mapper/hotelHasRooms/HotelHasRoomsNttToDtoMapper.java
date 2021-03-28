package siit.hotel_booking_web_app.mapper.hotelHasRooms;

import org.springframework.stereotype.Component;

import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

@Component
public class HotelHasRoomsNttToDtoMapper {
    public HotelHasRoomsRequestDto mapNttToDto(HotelHasRoomsEntity ntt) {

        return HotelHasRoomsRequestDto.builder()
                .roomType(ntt.getRoomType())
                .hotelId(ntt.getHotelId())
                .roomQuantity(ntt.getRoomQuantity())
                .pricePerNight(ntt.getPricePerNight())
                .build();
    }
}