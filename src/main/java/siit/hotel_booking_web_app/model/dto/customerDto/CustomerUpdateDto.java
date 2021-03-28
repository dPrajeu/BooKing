package siit.hotel_booking_web_app.model.dto.customerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateDto {
    private Integer customerId;

    @NotNull(message = "The first name may not be null.")
    private String firstName;

    @NotNull(message = "The last name may not be null.")
    private String lastName;

    @NotNull(message = "The e-mail address may not be null.")
    private String customerEmail;

    @NotNull(message = "The phone number may not be null.")
    private String phoneNumber;

    @NotNull(message = "The country may not be null.")
    private String country;

    @NotNull(message = "The city may not be null.")
    private String city;

    @NotNull(message = "The address may not be null.")
    private String address;

    @NotNull(message = "The loyalty level may not be null.")
    private Integer loyaltyLevel;

}
