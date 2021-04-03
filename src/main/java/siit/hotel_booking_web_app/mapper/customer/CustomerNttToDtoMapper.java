package siit.hotel_booking_web_app.mapper.customer;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerCreateNewDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerRequestDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;

@Component
public class CustomerNttToDtoMapper {

    public CustomerRequestDto mapNttToDto(CustomerEntity ntt) {

        return CustomerRequestDto.builder()
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

    public CustomerCreateNewDto createNttFromDto(CustomerEntity ntt) {

        return CustomerCreateNewDto.builder()
                .firstName(ntt.getFirstName())
                .lastName(ntt.getLastName())
                .socialId(ntt.getSocialId())
                .customerEmail(ntt.getCustomerEmail())
                .phoneNumber(ntt.getPhoneNumber())
                .birthDate(ntt.getBirthDate())
                .country(ntt.getCountry())
                .city(ntt.getCity())
                .address(ntt.getAddress())
                .build();
    }

}
