package siit.hotel_booking_web_app.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table (name = "customerloyalty")
public class CustomerLoyaltyEntity {

    @Id
    private Integer loyaltyId;

    private String loyaltyLevelName;

    private Integer discountPercent;

}
