package siit.hotel_booking_web_app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservationstatus")
public class ReservationStatusEntity {
    @Id
    private Integer statusId;

    private Integer statusName;

}
