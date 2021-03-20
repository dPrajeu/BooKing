package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import siit.hotel_booking_web_app.exceptions.customer.CustomerNotFoundException;
import siit.hotel_booking_web_app.mapper.customer.CustomerDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.customer.CustomerNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerCreateNewDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerRequestDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerUpdateDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.repository.CustomerRepository;


import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Configurable
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerNttToDtoMapper customerNttToDtoMapper;
    private final CustomerDtoToNttMapper customerDtoToNttMapper;

    public List<CustomerRequestDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerEntity -> customerNttToDtoMapper.mapEnttToDto(customerEntity))
                .collect(toList());
    }

    public CustomerRequestDto getCustomerById(Integer id) {
        return customerNttToDtoMapper.mapEnttToDto(customerRepository.findById(id).orElseThrow());
    }


    public List<CustomerRequestDto> getByLoyaltyLevel(Integer loyaltyLevel) {
        return customerRepository.findAllByLoyaltyLevel(loyaltyLevel)
                .stream()
                .map(customerEntity -> customerNttToDtoMapper.mapEnttToDto(customerEntity))
                .collect(toList());
    }

//    public List<CustomerDto> getByPhoneNumber(String phoneNumber) {
//        return customerRepository.findByPhoneNumber(phoneNumber)
//                .stream()
//                .map(customerEntity -> customerNttToDtoMapper.mapEnttToDto(customerEntity))
//                .collect(toList());
//    }

    public CustomerCreateNewDto createCustomerNtt(CustomerCreateNewDto customerCreateNewDto) {
        CustomerEntity mappedNtt = customerDtoToNttMapper.mapDtoToNtt(customerCreateNewDto);
        CustomerEntity savedNtt = customerRepository.save(mappedNtt);
        return customerNttToDtoMapper.createEnttfromDto(savedNtt);
    }


    public void deleteCustomerNtt(Integer customerId) {
      customerRepository.deleteById(customerId);
    }

    @Transactional
    public CustomerRequestDto updateCustomerNtt(CustomerUpdateDto customerUpdateDto) {
        Optional<CustomerEntity> byId = customerRepository.findById(customerUpdateDto.getCustomerId());
        CustomerEntity customerEntity = byId.orElseThrow(() -> new CustomerNotFoundException("No customer was found for the given ID: " + customerUpdateDto.getCustomerId()));

        customerEntity.setFirstName(customerUpdateDto.getFirstName());
        customerEntity.setLastName(customerUpdateDto.getLastName());
        customerEntity.setCustomerEmail(customerUpdateDto.getCustomerEmail());
        customerEntity.setPhoneNumber(customerUpdateDto.getPhoneNumber());
        customerEntity.setCountry(customerUpdateDto.getCountry());
        customerEntity.setCity(customerUpdateDto.getCity());
        customerEntity.setAddress(customerUpdateDto.getAddress());


//        ExampleMatcher customerMatcher = ExampleMatcher.matchingAny()
//                .withMatcher("customerId", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("socialId", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
//
//        Example <CustomerEntity> result  = Example.of(customerEntity,customerMatcher);

        return  customerNttToDtoMapper.mapEnttToDto(customerEntity);

    }


}
