package siit.hotel_booking_web_app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String firstName;

    private String lastName;

    private String socialId;

    private String customerEmail;

    private String phoneNumber;

    private String birthDate;

    private String country;

    private String city;

    private String address;

    @OneToOne
    @JoinColumn(name = "loyaltyLevel", referencedColumnName = "loyaltyId")
    private CustomerLoyaltyEntity loyaltyLevel;
}
