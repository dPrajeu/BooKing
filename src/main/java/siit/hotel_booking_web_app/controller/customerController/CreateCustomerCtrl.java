package siit.hotel_booking_web_app.controller.customerController;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.service.CustomerService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/customerdb")
public class CreateCustomerCtrl {
    private final CustomerService customerService;


}
