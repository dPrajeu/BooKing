package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.HotelEntity;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
    List<HotelEntity> findAllByCountry(String country);

    List<HotelEntity> findAllByCity(String city);

    List<HotelEntity> findAllByRating(Integer rating);
}
