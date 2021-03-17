package siit.hotel_booking_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    @Column(name = "hotelsId")
    private Integer hotelId;

    private String hotelName;

    private String hotelEmail;

    private String phoneNumber;

    private String country;

    private String city;

    private String address;

}
