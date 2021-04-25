package siit.hotel_booking_web_app.model.dto.reservation_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationFromDTOtoNTT {

    private Integer customerId;

    private Integer hotel;

    private Integer roomType;

    private LocalDate checkIn;

    private LocalDate checkOut;
}
