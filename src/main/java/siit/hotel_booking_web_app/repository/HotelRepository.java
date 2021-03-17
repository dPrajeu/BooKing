package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
}
