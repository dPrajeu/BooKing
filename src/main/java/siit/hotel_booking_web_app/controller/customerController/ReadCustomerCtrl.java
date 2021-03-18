package siit.hotel_booking_web_app.controller.customerController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerDto;
import siit.hotel_booking_web_app.service.CustomerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/customersdb")
public class ReadCustomerCtrl {
    private final CustomerService customerService;

    //list all customers
    //http://localhost:8080/front_page/customersdb/all_customers
    @RequestMapping(value = "/all_customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    //list customer details based on ID
    //http://localhost:8080/front_page/customersdb/idnumber
    @RequestMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto getCustomersById(@PathVariable(name = "customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    //list customers with specified Loyalty Level
    //http://localhost:8080/front_page/customersdb/loyalty_level?loyaltyLevel=
    @RequestMapping(value = "/loyalty_level", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getCustomersByLoyaltyLevel(@RequestParam(name = "loyaltyLevel") Integer loyaltyLevel) {
        return customerService.getByLoyaltyLevel(loyaltyLevel);
    }



}
