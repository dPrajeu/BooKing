package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.mapper.CustomerNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerDto;
import siit.hotel_booking_web_app.repository.CustomerRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Configurable
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerNttToDtoMapper customerNttToDtoMapper;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerEntity -> customerNttToDtoMapper.mapEnttToDto(customerEntity))
                .collect(toList());
    }

    public CustomerDto getCustomerById(Integer id) {
        return customerNttToDtoMapper.mapEnttToDto(customerRepository.findById(id).orElseThrow());


    }


    public List<CustomerDto> getByLoyaltyLevel(Integer loyaltyLevel) {
        return customerRepository.findAllByLoyaltyLevel(loyaltyLevel)
                .stream()
                .map(customerEntity -> customerNttToDtoMapper.mapEnttToDto(customerEntity))
                .collect(toList());
    }
}
