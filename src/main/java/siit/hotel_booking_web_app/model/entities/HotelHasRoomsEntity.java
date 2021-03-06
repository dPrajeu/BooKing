package siit.hotel_booking_web_app.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "HotelHasRoomsEntity")
@Table(name = "hotelshasrooms")
public class HotelHasRoomsEntity {

    @EmbeddedId
    private HotelHasRoomCompositPK hotelWithRooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("hotelId")
    @JoinColumn(name = "hotelId", referencedColumnName = "hotelId")
    @JsonBackReference (value = "hotelId")
    private HotelEntity hotelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roomType")
    @JoinColumn (name = "roomType", referencedColumnName = "roomTypeId")
    @JsonBackReference (value = "roomType")
    private RoomTypeEntity roomType;

    private Integer roomQuantity;

    private Double pricePerNight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        HotelHasRoomsEntity that = (HotelHasRoomsEntity) o;
        return Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(roomType, that.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, roomType);
    }

}
