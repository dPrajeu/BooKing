package siit.hotel_booking_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import siit.hotel_booking_web_app.repository.CustomerRepository;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customerId")
    private Integer customerId;

    //    @Column(name = "firstName")
    private String firstName;

    //    @Column(name = "lastName")
    private String lastName;

    //    @Column(name = "socialId")
    private String socialId;

    //    @Column(name = "customerEmail")
    private String customerEmail;

    //    @Column(name = "phoneNumber")
    private String phoneNumber;

    //    @Column(name = "birthDate")
    private String birthDate;

    private String country;

    private String city;

    private String address;

    private Integer loyaltyLevel;


}
