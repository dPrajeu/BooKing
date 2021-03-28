package siit.hotel_booking_web_app.model.dto.reservationDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationCreateNewDto {

    private CustomerEntity customerId;

    private HotelEntity hotel;

    private RoomTypeEntity roomType;

    private LocalDate checkIn;

    private LocalDate checkOut;

}
