package siit.hotel_booking_web_app.model.dto.hotel_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto.HotelHasRoomsRequestWithoutHotelDetailsDTO;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelRequestWithFilteredRoomDetailsDTO {

    private Integer hotelId;
    private String hotelName;
    private String phoneNumber;
    private String hotelEmail;
    private String country;
    private String city;
    private String address;
    private Integer rating;
    private List<HotelHasRoomsRequestWithoutHotelDetailsDTO> hotelHasRoomsRequestWithoutHotelDetailsDTOS;
}
