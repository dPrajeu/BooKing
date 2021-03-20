package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;
import siit.hotel_booking_web_app.service.CustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByCustomerId(CustomerEntity customerEntity);
    List<ReservationEntity> findByHotel(HotelEntity hotelEntity);

}
