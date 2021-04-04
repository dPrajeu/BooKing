package siit.hotel_booking_web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HotelBookingWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelBookingWebAppApplication.class, args);
    }
}

