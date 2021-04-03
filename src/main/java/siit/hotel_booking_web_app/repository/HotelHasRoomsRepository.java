package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;

import java.util.List;


@Repository
public interface HotelHasRoomsRepository extends JpaRepository<HotelHasRoomsEntity, HotelHasRoomCompositPK> {
   List<HotelHasRoomsEntity> findAllByHotelId(HotelEntity hotelEntity);
   HotelHasRoomsEntity findByHotelIdAndRoomType (HotelEntity hotelEntity, RoomTypeEntity roomTypeEntity);
}

