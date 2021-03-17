package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.repository.ReservationStatusRepository;

@Service
@Configurable
@RequiredArgsConstructor
public class ReservationStatusService {
    private final ReservationStatusRepository reservationStatusRepository;
}
