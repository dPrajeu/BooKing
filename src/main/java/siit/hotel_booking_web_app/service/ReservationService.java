package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
//import siit.hotel_booking_web_app.mapper.reservation.ReservationDtoToNttMapper;
import siit.hotel_booking_web_app.exceptions.customer.CustomerNotFoundException;
import siit.hotel_booking_web_app.exceptions.reservation.ReservationNotPossibleException;
import siit.hotel_booking_web_app.mapper.reservation.ReservationNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationFromDTOtoNTT;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.*;
import siit.hotel_booking_web_app.repository.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;


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
        ReservationStatusEntity reservationStatusEntity = reservationStatusRepository.findById(status).orElseThrow();

        return reservationRepository.findAllByStatus(reservationStatusEntity)
                .stream()
                .map(reservationEntity -> reservationNttToDtoMapper.mapNttToDto(reservationEntity))
                .collect(toList());
    }

    public ReservationRequestDto createReservationNtt(ReservationFromDTOtoNTT reservationFromDTOtoNTT) {

        ReservationEntity mappedNtt = prepareReservationDetails(reservationFromDTOtoNTT);
        if (hotelHasRoomsRepository.getRoomNumbersForValidation(mappedNtt.getHotel().getHotelId(), mappedNtt.getRoomType().getRoomTypeId())
                <= reservationRepository.getReservationValidation(mappedNtt.getHotel().getHotelId(), mappedNtt.getRoomType().getRoomTypeId(), mappedNtt.getCheckIn(), mappedNtt.getCheckOut())) {
            throw new ReservationNotPossibleException("All rooms in the selected category have been booked for this hotel in the selected interval. " +
                    "Please select a different period or another room type.");
        } else {
            ReservationEntity savedNtt = reservationRepository.save(mappedNtt);
            return reservationNttToDtoMapper.mapNttToDto(savedNtt);
        }

    }

    private ReservationEntity prepareReservationDetails(ReservationFromDTOtoNTT reservationFromDTOtoNTT) {
        CustomerEntity customerEntity = customerRepository.findByCustomerId(reservationFromDTOtoNTT.getCustomerId());
        HotelEntity hotelEntity = hotelRepository.findByHotelId(reservationFromDTOtoNTT.getHotel());
        RoomTypeEntity roomTypeEntity = roomTypeRepository.findByRoomTypeId(reservationFromDTOtoNTT.getRoomType());
        HotelHasRoomsEntity hotelHasRoomsEntity = hotelHasRoomsRepository.findByHotelIdAndRoomType(hotelEntity, roomTypeEntity);

        int reservationNumberOfDays = (int) ChronoUnit.DAYS.between(reservationFromDTOtoNTT.getCheckIn(), reservationFromDTOtoNTT.getCheckOut());
        double reservationPriceBeforeDiscount = reservationNumberOfDays * hotelHasRoomsEntity.getPricePerNight();
        double reservationPriceWithDiscount = reservationPriceBeforeDiscount - (reservationPriceBeforeDiscount * customerEntity.getLoyaltyLevel().getDiscountPercent() / 100);
        return getMappedReservationNtt(reservationFromDTOtoNTT, customerEntity, hotelEntity, roomTypeEntity, reservationPriceWithDiscount);

    }

    private ReservationEntity getMappedReservationNtt(ReservationFromDTOtoNTT reservationFromDTOtoNTT, CustomerEntity customerEntity, HotelEntity hotelEntity, RoomTypeEntity roomTypeEntity, double reservationPriceWithDiscount) {
       return ReservationEntity.builder()
                .customerId(customerRepository.findByCustomerId(reservationFromDTOtoNTT.getCustomerId()))
                .hotel(hotelEntity)
                .roomType(roomTypeEntity)
                .checkIn(reservationFromDTOtoNTT.getCheckIn())
                .checkOut(reservationFromDTOtoNTT.getCheckOut())
                .priceTotal(reservationPriceWithDiscount)
                .discountPercent(customerEntity.getLoyaltyLevel().getDiscountPercent())
                .status(reservationStatusRepository.getOne(1))
                .build();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void CheckForReservationsThatHaveEnded() {

        List<ReservationEntity> reservationEntityList = reservationRepository.findAllByCheckOutBefore(LocalDate.now());
        reservationEntityList.stream()
                .forEach(reservationEntity -> {
                    reservationEntity.setStatus(reservationStatusRepository.getOne(5));
                    reservationRepository.save(reservationEntity);
                });
    }

    public void cancelReservation(Integer reservationId) {
       ReservationEntity reservationEntity = reservationRepository.findById(reservationId).orElseThrow(() -> new ReservationNotPossibleException("No reservation found by the specified ID " + reservationId));
       reservationEntity.setStatus(reservationStatusRepository.getOne(4));
       reservationRepository.save(reservationEntity);
    }
}
