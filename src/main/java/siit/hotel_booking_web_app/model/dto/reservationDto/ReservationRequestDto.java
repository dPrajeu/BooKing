package siit.hotel_booking_web_app.model.dto.reservationDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.ReservationStatusEntity;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationRequestDto {

    private Integer reservationId;

    private String customerName;

    private Integer hotelId;

    private String hotelName;

    private Integer roomTypeId;

    private String roomTypeName;

    private Double pricePerNight;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Double priceTotal;

    private Integer discountPercent;

    private String status;
}
