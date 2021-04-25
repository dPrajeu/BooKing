package siit.hotel_booking_web_app.model.dto.reservation_status_dto;

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
