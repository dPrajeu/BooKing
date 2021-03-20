package siit.hotel_booking_web_app.model.dto.hotelDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelRequestDto {

    private Integer hotelId;

    private String hotelName;

    private String phoneNumber;

    private String hotelEmail;

    private String country;

    private String city;

    private String address;
}


