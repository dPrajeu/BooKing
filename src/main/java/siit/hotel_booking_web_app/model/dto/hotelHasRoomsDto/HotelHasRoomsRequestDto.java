package siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelHasRoomsRequestDto {

    private HotelHasRoomCompositPK hotelWithRooms;

    private HotelEntity hotelId;

    private RoomTypeEntity roomType;

    private Integer roomQuantity;

    private Double pricePerNight;

}
