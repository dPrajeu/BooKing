package siit.hotel_booking_web_app.model.dto.customerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
public class CustomerDto {

    @Id
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

    private Integer loyaltyLevel;
}
