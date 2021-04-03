package siit.hotel_booking_web_app.model.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationId;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    @JsonManagedReference
    private CustomerEntity customerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel", referencedColumnName = "hotelId")
    @JsonManagedReference
    private HotelEntity hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomType", referencedColumnName = "roomTypeId")
    @JsonManagedReference
    private RoomTypeEntity roomType;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Double priceTotal;

    private Integer discountPercent;

    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "statusId")
    private ReservationStatusEntity status;

}
