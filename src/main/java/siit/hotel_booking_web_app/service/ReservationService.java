package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.repository.ReservationRepository;

@Service
@Configurable
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

}
