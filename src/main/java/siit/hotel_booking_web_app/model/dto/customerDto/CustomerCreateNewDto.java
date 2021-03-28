package siit.hotel_booking_web_app.model.dto.customerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.CustomerLoyaltyEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreateNewDto {

    private String firstName;

    private String lastName;

    private String socialId;

    private String customerEmail;

    private String phoneNumber;

    private String birthDate;

    private String country;

    private String city;

    private String address;

    private CustomerLoyaltyEntity loyaltyLevel;

}

