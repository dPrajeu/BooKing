package siit.hotel_booking_web_app.mapper.reservation;


import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;
import siit.hotel_booking_web_app.model.entities.ReservationStatusEntity;

import java.time.temporal.ChronoUnit;


@Component
public class ReservationDtoToNttMapper {

    public ReservationEntity mapDtoToNtt(ReservationCreateNewDto reservationCreateNewDto) {

        int reservationNumberOfDays = (int) ChronoUnit.DAYS.between(reservationCreateNewDto.getCheckIn(),reservationCreateNewDto.getCheckOut());


        return ReservationEntity.builder()
                .customerId(reservationCreateNewDto.getCustomerId())
                .hotel(reservationCreateNewDto.getHotel())
                .roomType(reservationCreateNewDto.getRoomType())
                .checkIn(reservationCreateNewDto.getCheckIn())
                .checkOut(reservationCreateNewDto.getCheckOut())
//                .priceTotal(reservationCreateNewDto.getPriceTotal())
//                .discountPercent(reservationCreateNewDto.getDiscountPercent())
//                .status(ReservationStatusEntity.class.cast(reservationCreateNewDto.getStatus()))
                .build();
    }


}