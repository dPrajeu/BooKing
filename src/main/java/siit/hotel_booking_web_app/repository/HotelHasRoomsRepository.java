package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

import java.util.List;


@Repository
public interface HotelHasRoomsRepository extends JpaRepository<HotelHasRoomsEntity, HotelHasRoomCompositPK> {
   List<HotelHasRoomsEntity> findByHotelId(Integer hotelId);
}

