package siit.hotel_booking_web_app.model.dto.customer_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import siit.hotel_booking_web_app.model.entities.CustomerLoyaltyEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequestDto {

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

    private CustomerLoyaltyEntity loyaltyLevel;
}
