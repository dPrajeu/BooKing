package siit.hotel_booking_web_app.mapper.reservation;


import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;

@Component
public class ReservationNttToDtoMapper {

    public ReservationRequestDto mapNttToDto(ReservationEntity reservationEntity) {
        return ReservationRequestDto.builder()
                .reservationId(reservationEntity.getReservationId())
                .customerId(reservationEntity.getCustomerId())
                .hotel(reservationEntity.getHotel())
                .roomType(reservationEntity.getRoomType())
                .checkIn(reservationEntity.getCheckIn())
                .checkOut(reservationEntity.getCheckOut())
                .priceTotal(reservationEntity.getPriceTotal())
                .discountPercent(reservationEntity.getDiscountPercent())
                .status(reservationEntity.getStatus())
                .build();
    }
}
