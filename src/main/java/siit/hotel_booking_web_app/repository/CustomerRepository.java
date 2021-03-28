package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.CustomerLoyaltyEntity;


import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findAllByLoyaltyLevel(CustomerLoyaltyEntity customerLoyaltyEntity);

//    Optional<CustomerEntity> findByPhoneNumber(String phoneNumber);

}
