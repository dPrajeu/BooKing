package siit.hotel_booking_web_app.mapper.customer;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.customer_dto.CustomerCreateNewDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;

@Component
public class CustomerDtoToNttMapper {

    public CustomerEntity mapDtoToNtt(CustomerCreateNewDto customerCreateNewDto) {
        return CustomerEntity.builder()
                .firstName(customerCreateNewDto.getFirstName())
                .lastName(customerCreateNewDto.getLastName())
                .socialId(customerCreateNewDto.getSocialId())
                .customerEmail(customerCreateNewDto.getCustomerEmail())
                .phoneNumber(customerCreateNewDto.getPhoneNumber())
                .birthDate(customerCreateNewDto.getBirthDate())
                .country(customerCreateNewDto.getCountry())
                .city(customerCreateNewDto.getCity())
                .address(customerCreateNewDto.getAddress())
                .loyaltyLevel(customerCreateNewDto.getLoyaltyLevel())
                .build();
    }
}
