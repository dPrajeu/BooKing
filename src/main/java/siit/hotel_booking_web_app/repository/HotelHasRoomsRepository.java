package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.HotelHasRoomsEntity;

@Repository
public interface HotelHasRoomsRepository extends JpaRepository<HotelHasRoomsEntity, Integer> {
}
