package siit.hotel_booking_web_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.CustomerLoyaltyEntity;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    List<CustomerEntity> findAllByLoyaltyLevel(CustomerLoyaltyEntity customerLoyaltyEntity);
    CustomerEntity findByCustomerId(Integer customerId);
}
