package siit.hotel_booking_web_app.mapper.reservation;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;

import java.time.temporal.ChronoUnit;


@Component
public class ReservationNttToDtoMapper {

    public ReservationRequestDto mapNttToDto(ReservationEntity reservationEntity) {

        return ReservationRequestDto.builder()
                .reservationId(reservationEntity.getReservationId())
                .customerName(reservationEntity.getCustomerId().getFirstName().concat(" " + reservationEntity.getCustomerId().getLastName()))
                .hotelId(reservationEntity.getHotel().getHotelId())
                .hotelName(reservationEntity.getHotel().getHotelName())
                .roomTypeId(reservationEntity.getRoomType().getRoomTypeId())
                .roomTypeName(reservationEntity.getRoomType().getRoomType())
                .pricePerNight(reservationEntity.getPriceTotal() / (int) ChronoUnit.DAYS.between(reservationEntity.getCheckIn(), reservationEntity.getCheckOut()))
                .checkIn(reservationEntity.getCheckIn())
                .checkOut(reservationEntity.getCheckOut())
                .priceTotal(reservationEntity.getPriceTotal())
                .discountPercent(reservationEntity.getDiscountPercent())
                .status(reservationEntity.getStatus().getStatusName())
                .build();
    }

    public ReservationCreateNewDto createDTOFromNTT(ReservationEntity savedNtt) {

        return ReservationCreateNewDto.builder()
                .customerId(savedNtt.getCustomerId())
                .hotel(savedNtt.getHotel())
                .roomType(savedNtt.getRoomType())
                .checkIn(savedNtt.getCheckIn())
                .checkOut(savedNtt.getCheckOut())
                .build();
    }

}
