package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomCompositPK;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;

import java.util.List;


@Repository
public interface HotelHasRoomsRepository extends JpaRepository<HotelHasRoomsEntity, HotelHasRoomCompositPK> {

   List<HotelHasRoomsEntity> findAllByHotelId(HotelEntity hotelEntity);

   @Query(value = "SELECT *" +
           "From hotelshasrooms\n" +
           "Where hotelId = :hotelId\n" +
           "And roomType = :roomType", nativeQuery = true)
   HotelHasRoomsEntity findByHotelIdAndRoomType (HotelEntity hotelId, RoomTypeEntity roomType);

   @Query(value = "SELECT roomQuantity\n" +
           "From hotelshasrooms\n" +
           "Where hotelId = :hotelId\n" +
           "And roomType = :roomType", nativeQuery = true)
   Integer getRoomNumbersForValidation (@Param("hotelId") Integer hotelId, @Param("roomType") Integer roomType);

   @Query(value = "SELECT *" +
           "From hotelshasrooms\n" +
           "Where roomType = :roomType", nativeQuery = true)
   List <HotelHasRoomsEntity> findByRoomType(Integer roomType);
}

