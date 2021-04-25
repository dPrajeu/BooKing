package siit.hotel_booking_web_app.model.dto.hotel_dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class HotelUpdateDto {

    private Integer hotelId;

    @NotNull(message = "The hotel name may not be null.")
    private String hotelName;

    @NotNull(message = "The phone number may not be null.")
    private String phoneNumber;

    @NotNull(message = "The e-mail address may not be null.")
    private String hotelEmail;

    @NotNull(message = "The country may not be null.")
    private String country;

    @NotNull(message = "The city may not be null.")
    private String city;

    @NotNull(message = "The address may not be null.")
    private String address;

    @NotNull(message = "The rating may not be null.")
    private Integer rating;
}
