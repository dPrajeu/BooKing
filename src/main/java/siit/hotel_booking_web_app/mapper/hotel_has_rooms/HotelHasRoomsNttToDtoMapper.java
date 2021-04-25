package siit.hotel_booking_web_app.mapper.hotel_has_rooms;

import org.springframework.stereotype.Component;

import siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

@Component
public class HotelHasRoomsNttToDtoMapper {
    public HotelHasRoomsRequestDto mapNttToDto(HotelHasRoomsEntity ntt) {

        return HotelHasRoomsRequestDto.builder()
                .hotelId(ntt.getHotelId().getHotelId())
                .hotelName(ntt.getHotelId().getHotelName())
                .roomTypeId(ntt.getRoomType().getRoomTypeId())
                .roomTypeName(ntt.getRoomType().getRoomType())
                .roomQuantity(ntt.getRoomQuantity())
                .pricePerNight(ntt.getPricePerNight())
                .build();
    }

}
