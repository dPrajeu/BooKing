package siit.hotel_booking_web_app.model.dto.hotelDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelCreateDto {

    private String hotelName;

    private String phoneNumber;

    private String hotelEmail;

    private String country;

    private String city;

    private String address;

    private Integer rating;

    private List<HotelHasRoomsEntity> hotelHasRoomsEntitiesList;


}
