package siit.hotel_booking_web_app.customer.controllerTests;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import siit.hotel_booking_web_app.controller.CustomerController;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerRequestDto;
import siit.hotel_booking_web_app.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {


    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void celMaiSimpluTest(){
        CustomerRequestDto customerRequestDto = CustomerRequestDto.builder().build();
        Mockito.when(customerService.getCustomerById(123)).thenReturn(customerRequestDto);

        CustomerRequestDto customerById = customerController.getCustomersById(123);

        Assertions.assertThat(customerById).isSameAs(customerRequestDto);

    }


}
