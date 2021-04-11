package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;
import siit.hotel_booking_web_app.model.entities.ReservationStatusEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
    List<ReservationEntity> findByCustomerId(CustomerEntity customerEntity);
    List<ReservationEntity> findByHotel(HotelEntity hotelEntity);
    List<ReservationEntity> findAllByStatus(ReservationStatusEntity reservationStatusEntity);
    List<ReservationEntity> findAllByCheckOutBefore (LocalDate localDate);

    @Query(value = "SELECT COUNT(*) AS total_bookings\n" +
            "FROM reservations rs\n" +
            "WHERE rs.hotel= :hotel\n" +
            "AND rs.roomType= :roomType\n" +
            "AND rs.checkIn >=  :checkIn\n" +
            "AND rs.checkOut <= :checkOut", nativeQuery = true)
    Integer getReservationValidation (@Param("hotel") Integer hotel, @Param("roomType") Integer roomType,
                                      @Param("checkIn")LocalDate checkIn, @Param("checkOut") LocalDate checkOut);


}
