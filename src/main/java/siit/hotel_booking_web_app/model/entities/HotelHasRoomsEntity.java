package siit.hotel_booking_web_app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(HotelHasRoomCompositPK.class)
@Entity
@Table(name = "hotelshasrooms")
public class HotelHasRoomsEntity implements Serializable {

    @Id
    private Integer hotelId;

    @Id
    private Integer roomType;

    private Integer roomQuantity;

    private Double pricePerNight;
}
