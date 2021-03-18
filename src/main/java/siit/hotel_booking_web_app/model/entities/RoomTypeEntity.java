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
@Table(name = "roomtypes")
public class RoomTypeEntity {
    @Id
    private Integer roomTypeId;

    private String roomType;
}
