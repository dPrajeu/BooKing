package siit.hotel_booking_web_app.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.repository.CustomerLoyaltyRepository;

@Service
@Configurable
@RequiredArgsConstructor
public class CustomerLoyaltyService {

    private final CustomerLoyaltyRepository customerLoyaltyRepository;
}
