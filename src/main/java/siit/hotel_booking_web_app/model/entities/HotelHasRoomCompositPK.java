package siit.hotel_booking_web_app.model.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class HotelHasRoomCompositPK implements Serializable {

    private Integer hotelId;
    private Integer roomType;

    public HotelHasRoomCompositPK(Integer hotelId, Integer roomType){
        this.hotelId = hotelId;
        this.roomType = roomType;
    }
}
