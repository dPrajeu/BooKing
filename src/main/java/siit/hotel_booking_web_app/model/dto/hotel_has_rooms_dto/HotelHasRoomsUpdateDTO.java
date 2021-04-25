package siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelHasRoomsUpdateDTO {

    private Integer roomQuantity;

    private Double pricePerNight;
}
