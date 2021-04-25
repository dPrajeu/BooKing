package siit.hotel_booking_web_app.mapper.reservation;


import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;


@Component
public class ReservationDtoToNttMapper {

    public ReservationEntity mapDtoToNtt(ReservationCreateNewDto reservationCreateNewDto) {

        return ReservationEntity.builder()
                .customerId(reservationCreateNewDto.getCustomerId())
                .hotel(reservationCreateNewDto.getHotel())
                .roomType(reservationCreateNewDto.getRoomType())
                .checkIn(reservationCreateNewDto.getCheckIn())
                .checkOut(reservationCreateNewDto.getCheckOut())
                .build();
    }

}
