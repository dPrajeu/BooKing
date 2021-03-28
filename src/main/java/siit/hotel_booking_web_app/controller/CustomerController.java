package siit.hotel_booking_web_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerCreateNewDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerRequestDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerUpdateDto;
import siit.hotel_booking_web_app.service.CustomerService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/customersdb")
public class CustomerController {
    private final CustomerService customerService;

    //list all customers
    //http://localhost:8080/front_page/customersdb/all_customers
    @RequestMapping(value = "/all_customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerRequestDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    //list customer details based on ID
    //http://localhost:8080/front_page/customersdb/1
    @RequestMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerRequestDto getCustomersById(@PathVariable(name = "customerId") Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    //list customers with specified Loyalty Level
    //http://localhost:8080/front_page/customersdb/loyalty_level?loyaltyLevel=
    @RequestMapping(value = "/loyalty_level", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerRequestDto> getCustomersByLoyaltyLevel(@RequestParam(name = "loyaltyLevel") Integer loyaltyLevel) {
        return customerService.getByLoyaltyLevel(loyaltyLevel);
    }

    //create a new customer
    //http://localhost:8080/front_page/customersdb/create_customer
    @PostMapping(value = "/create_customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerCreateNewDto createCustomerNtt(@RequestBody CustomerCreateNewDto customerCreateNewDto) {

        return customerService.createCustomerNtt(customerCreateNewDto);
    }

    //delete a customer by ID
    //http://localhost:8080/front_page/customersdb/delete?customerId=
    @ResponseStatus(HttpStatus.IM_USED)
    @DeleteMapping(value = "/delete{customerId}")
    public void deleteCustomerNtt(@RequestParam(name = "customerId") Integer customerId) {
        customerService.deleteCustomerNtt(customerId);
    }

    //update a customer info by ID
    //http://localhost:8080/front_page/customersdb/update100
    @PutMapping(value = "/update{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerRequestDto updateCustomerDetails(@PathVariable(name = "customerId") Integer customerId,
                                                    @RequestBody @Valid CustomerUpdateDto customerUpdateDto) {
        customerUpdateDto.setCustomerId(customerId);
        return customerService.updateCustomerNtt(customerUpdateDto);
    }

}
