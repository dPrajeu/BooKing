package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
//import siit.hotel_booking_web_app.mapper.reservation.ReservationDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.reservation.ReservationNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationFromDTOtoNTT;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.*;
import siit.hotel_booking_web_app.repository.*;

import java.time.temporal.ChronoUnit;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Service
@Configurable
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationNttToDtoMapper reservationNttToDtoMapper;
    private final CustomerRepository customerRepository;
    private final HotelRepository hotelRepository;
    private final ReservationStatusRepository reservationStatusRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final HotelHasRoomsRepository hotelHasRoomsRepository;


    public List<ReservationRequestDto> findAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationEntity -> reservationNttToDtoMapper.mapNttToDto(ReservationEntity))
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationById(Integer reservationId) {
        return reservationRepository.findById(reservationId)
                .stream()
                .map(ReservationEntity -> reservationNttToDtoMapper.mapNttToDto(ReservationEntity))
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationByCustomerId(Integer customerId) {

        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();

        return reservationRepository.findByCustomerId(customerEntity)
                .stream()
                .map(ReservationEntity -> reservationNttToDtoMapper.mapNttToDto(ReservationEntity))
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationByHotel(Integer hotel) {
        HotelEntity hotelEntity = hotelRepository.findById(hotel).orElseThrow();

        return reservationRepository.findByHotel(hotelEntity)
                .stream()
                .map(ReservationEntity -> reservationNttToDtoMapper.mapNttToDto(ReservationEntity))
                .collect(toList());
    }

    public List<ReservationRequestDto> findAllReservationsFromHotelForCustomer(Integer hotel, Integer customerId) {

        HotelEntity hotelEntity = hotelRepository.findById(hotel).orElseThrow();
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();

        return reservationRepository.findByHotel(hotelEntity)
                .stream()
                .filter(reservationEntity -> reservationEntity.getCustomerId().equals(customerEntity))
                .map(ReservationEntity -> reservationNttToDtoMapper.mapNttToDto(ReservationEntity))
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationsByStatus(Integer status) {
        ReservationStatusEntity reservationStatusEntity = reservationStatusRepository.findById(status).orElseThrow().getStatus();

        return reservationRepository.findAllByStatus(reservationStatusEntity)
                .stream()
                .map(reservationEntity -> reservationNttToDtoMapper.mapNttToDto(reservationEntity))
                .collect(toList());
    }

    public ReservationRequestDto createReservationNtt(ReservationFromDTOtoNTT reservationFromDTOtoNTT) {


        CustomerEntity customerEntity = customerRepository.findByCustomerId(reservationFromDTOtoNTT.getCustomerId());
        HotelEntity hotelEntity = hotelRepository.findByHotelId(reservationFromDTOtoNTT.getHotel());
        RoomTypeEntity roomTypeEntity = roomTypeRepository.findByRoomTypeId(reservationFromDTOtoNTT.getRoomType());
        HotelHasRoomsEntity hotelHasRoomsEntity = hotelHasRoomsRepository.findByHotelIdAndRoomType(hotelEntity, roomTypeEntity);

        int reservationNumberOfDays = (int) ChronoUnit.DAYS.between(reservationFromDTOtoNTT.getCheckIn(),reservationFromDTOtoNTT.getCheckOut());
        double reservationPriceBeforeDiscount = reservationNumberOfDays * hotelHasRoomsEntity.getPricePerNight();
        double reservationPriceWithDiscount = reservationPriceBeforeDiscount - (reservationPriceBeforeDiscount *
                customerEntity.getLoyaltyLevel().getDiscountPercent() / 100);

        ReservationEntity mappedNtt = ReservationEntity.builder()
                .customerId(customerRepository.findByCustomerId(reservationFromDTOtoNTT.getCustomerId()))
                .hotel(hotelEntity)
                .roomType(roomTypeEntity)
                .checkIn(reservationFromDTOtoNTT.getCheckIn())
                .checkOut(reservationFromDTOtoNTT.getCheckOut())
                .priceTotal(reservationPriceWithDiscount)
                .discountPercent(customerEntity.getLoyaltyLevel().getDiscountPercent())
                .status(reservationStatusRepository.getOne(1).getStatus())
                .build();

        ReservationEntity savedNtt = reservationRepository.save(mappedNtt);
        return reservationNttToDtoMapper.mapNttToDto(savedNtt);


    }
}
