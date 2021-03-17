package siit.hotel_booking_web_app.model;

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
@Table(name = "hotelshasrooms")
public class HotelHasRoomsEntity {

    @Id
    private Integer hotelId;

    @Id
    private Integer roomType;

    private Integer roomQuantity;

    private Double pricePerNight;
}
