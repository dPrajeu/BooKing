package siit.hotel_booking_web_app.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    private Integer reservationId;

    private Integer customerId;

    private Integer hotel;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Double priveTotal;

    private Integer discount;

    private Integer status;
}
