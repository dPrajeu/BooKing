package siit.hotel_booking_web_app.model.entities;

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

    @JsonManagedReference(value = "hotelId")
    @OneToMany(mappedBy = "hotelId",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<HotelHasRoomsEntity> hotelHasRoomsEntityList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        var hotelEntity = (HotelEntity) o;
        return Objects.equals(hotelName, hotelEntity.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName);
    }

}
