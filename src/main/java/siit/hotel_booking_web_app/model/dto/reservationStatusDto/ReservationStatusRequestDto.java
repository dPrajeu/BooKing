package siit.hotel_booking_web_app.model.dto.reservationStatusDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservationStatusRequestDto {

    private Integer statusId;

    private String statusName;

}
