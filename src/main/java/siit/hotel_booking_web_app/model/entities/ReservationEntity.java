package siit.hotel_booking_web_app.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {

    @Id
    private Integer reservationId;

    @OneToOne
    @JoinColumn(name ="customerId", referencedColumnName = "customerId")
    private CustomerEntity customerId;

    @OneToOne
    @JoinColumn(name ="hotel", referencedColumnName = "hotelId")
    private HotelEntity hotel;

    @OneToOne
    @JoinColumn (name="roomType", referencedColumnName = "roomTypeId")
    private RoomTypeEntity roomType;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Double priceTotal;

    private Integer discountPercent;

    private Integer status;
}
