package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.repository.HotelRepository;

@Service
@Configurable
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
}
