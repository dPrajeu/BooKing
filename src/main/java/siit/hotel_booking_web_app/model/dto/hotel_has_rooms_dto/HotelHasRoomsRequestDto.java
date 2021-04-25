package siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelHasRoomsRequestDto {

    private Integer hotelId;

    private String hotelName;

    private Integer roomTypeId;

    private String roomTypeName;

    private Integer roomQuantity;

    private Double pricePerNight;

}
