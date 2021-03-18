package siit.hotel_booking_web_app.mapper;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;

@Component
public class CustomerNttToDtoMapper {

    public CustomerDto mapEnttToDto(CustomerEntity ntt) {

        return CustomerDto.builder()
                .customerId(ntt.getCustomerId())
                .firstName(ntt.getFirstName())
                .lastName(ntt.getLastName())
                .socialId(ntt.getSocialId())
                .customerEmail(ntt.getCustomerEmail())
                .phoneNumber(ntt.getPhoneNumber())
                .birthDate(ntt.getBirthDate())
                .country(ntt.getCountry())
                .city(ntt.getCity())
                .address(ntt.getAddress())
                .loyaltyLevel(ntt.getLoyaltyLevel())
                .build();
    }
}
