package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
//import siit.hotel_booking_web_app.mapper.reservation.ReservationDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.reservation.ReservationNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.model.entities.ReservationStatusEntity;
import siit.hotel_booking_web_app.repository.CustomerRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;
import siit.hotel_booking_web_app.repository.ReservationRepository;
import siit.hotel_booking_web_app.repository.ReservationStatusRepository;

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
//    private final ReservationDtoToNttMapper reservationDtoToNttMapper;

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

//    public ReservationCreateNewDto createReservationNtt(ReservationCreateNewDto reservationCreateNewDto) {
//        ReservationEntity mappedNtt = reservationDtoToNttMapper.mapDtoToNtt(reservationCreateNewDto);
//        ReservationEntity savedNtt = reservationRepository.save(mappedNtt);
//        return reservationNttToDtoMapper.createNttfromDto(savedNtt);
//    }
}
