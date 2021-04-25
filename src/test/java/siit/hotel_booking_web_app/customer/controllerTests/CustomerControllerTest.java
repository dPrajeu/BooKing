package siit.hotel_booking_web_app.customer.controllerTests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.PathVariable;
import siit.hotel_booking_web_app.controller.CustomerController;
import siit.hotel_booking_web_app.model.dto.customer_dto.CustomerRequestDto;
import siit.hotel_booking_web_app.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {


    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void getCustomer_whenGivenAValidCustomerId_returnCustomerDetails(){

        CustomerRequestDto customerRequestDto = CustomerRequestDto.builder().build();
        when(customerService.getCustomerById(123)).thenReturn(customerRequestDto);

        CustomerRequestDto customerById = customerController.getCustomersById(123);
        assertThat(customerById).isSameAs(customerRequestDto);
    }

    public CustomerRequestDto getCustomersById(@PathVariable(name = "customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @Test
    public void getAllCustomers_whenGivenValidURL_returnCustomersList(){
        List <CustomerRequestDto> customerRequestDtoList = new ArrayList<>();
        CustomerRequestDto customerRequestDto = CustomerRequestDto.builder().build();
        customerRequestDtoList.add(customerRequestDto);
        when(customerService.getAllCustomers()).thenReturn(customerRequestDtoList);

        List<CustomerRequestDto> customerRequestDtoList1 = customerController.getAllCustomers();
        assertThat(customerRequestDtoList1).isNotEmpty()
                .isSameAs(customerRequestDtoList);
    }

    public List<CustomerRequestDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }


}
