package siit.hotel_booking_web_app.model.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "roomtypes")
public class RoomTypeEntity {

    @Id
    private Integer roomTypeId;

    @NaturalId
    private String roomType;

    @JsonManagedReference(value = "roomType")
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelHasRoomsEntity> hotelHasRoomsEntitiesList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomTypeEntity tag = (RoomTypeEntity) o;
        return Objects.equals(roomType, tag.roomType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType);
    }

}
