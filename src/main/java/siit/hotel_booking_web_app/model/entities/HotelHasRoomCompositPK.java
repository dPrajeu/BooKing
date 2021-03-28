package siit.hotel_booking_web_app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class HotelHasRoomCompositPK implements Serializable {

    private Integer hotelId;

    private Integer roomType;


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        HotelHasRoomCompositPK that = (HotelHasRoomCompositPK) o;
        return Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(roomType, that.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, roomType);
    }


}
