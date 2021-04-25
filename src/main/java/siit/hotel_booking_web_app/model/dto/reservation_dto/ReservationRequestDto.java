package siit.hotel_booking_web_app.model.dto.reservation_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
