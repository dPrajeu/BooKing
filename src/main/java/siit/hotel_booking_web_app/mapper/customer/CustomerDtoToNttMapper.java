package siit.hotel_booking_web_app.mapper.customer;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerCreateNewDto;
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

//    public CustomerEntity updateCustomerMap(CustomerUpdateDto customerUpdateDto) {
//        return CustomerEntity.builder()
//                .firstName(customerUpdateDto.getFirstName())
//                .lastName(customerUpdateDto.getLastName())
//                .customerEmail(customerUpdateDto.getCustomerEmail())
//                .phoneNumber(customerUpdateDto.getPhoneNumber())
//                .country(customerUpdateDto.getCountry())
//                .city(customerUpdateDto.getCity())
//                .address(customerUpdateDto.getAddress())
//                .build();
//    }


}
