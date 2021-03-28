package siit.hotel_booking_web_app.model.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    private String hotelName;

    private String hotelEmail;

    private String phoneNumber;

    private String country;

    private String city;

    private String address;

    private Integer rating;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotelId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<HotelHasRoomsEntity> hotelHasRoomsEntityList;


//    public void addRoomTypes(RoomTypeEntity roomTypeEntity) {
//        HotelHasRoomsEntity hotelHasRoomsEntity = new HotelHasRoomsEntity(this, roomTypeEntity);
//        hotelHasRoomsEntityList.add(hotelHasRoomsEntity);
//        roomTypeEntity.getHotelHasRoomsEntitiesList().add(hotelHasRoomsEntity);
//    }
//
//    public void removeRoomTypes(RoomTypeEntity roomTypeEntity) {
//        for (Iterator<HotelHasRoomsEntity> iterator = hotelHasRoomsEntityList.iterator();
//             iterator.hasNext(); ) {
//            HotelHasRoomsEntity hotelHasRoomsEntity = iterator.next();
//
//            if (hotelHasRoomsEntity.getHotelId().equals(this) &&
//                    hotelHasRoomsEntity.getRoomType().equals(roomTypeEntity)) {
//                iterator.remove();
//                hotelHasRoomsEntity.getRoomType().getHotelHasRoomsEntitiesList().remove(hotelHasRoomsEntity);
//                hotelHasRoomsEntity.setHotelId(null);
//                hotelHasRoomsEntity.setRoomType(null);
//            }
//        }
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        HotelEntity hotelEntity = (HotelEntity) o;
        return Objects.equals(hotelName, hotelEntity.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName);
    }

}
