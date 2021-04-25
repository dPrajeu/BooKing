package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import siit.hotel_booking_web_app.exceptions.reservation.ReservationNotPossibleException;
import siit.hotel_booking_web_app.mapper.reservation.ReservationNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationFromDTOtoNTT;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.*;
import siit.hotel_booking_web_app.repository.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationById(Integer reservationId) {
        return reservationRepository.findById(reservationId)
                .stream()
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationByCustomerId(Integer customerId) {

        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();

        return reservationRepository.findByCustomerId(customerEntity)
                .stream()
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationByHotel(Integer hotel) {
        HotelEntity hotelEntity = hotelRepository.findById(hotel).orElseThrow();

        return reservationRepository.findByHotel(hotelEntity)
                .stream()
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    public List<ReservationRequestDto> findAllReservationsFromHotelForCustomer(Integer hotel, Integer customerId) {

        HotelEntity hotelEntity = hotelRepository.findById(hotel).orElseThrow();
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElseThrow();

        return reservationRepository.findByHotel(hotelEntity)
                .stream()
                .filter(reservationEntity -> reservationEntity.getCustomerId().equals(customerEntity))
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    public List<ReservationRequestDto> findReservationsByStatus(Integer status) {
        ReservationStatusEntity reservationStatusEntity = reservationStatusRepository.findById(status).orElseThrow();

        return reservationRepository.findAllByStatus(reservationStatusEntity)
                .stream()
                .map(reservationNttToDtoMapper::mapNttToDto)
                .collect(toList());
    }

    //____________________Create a new reservation___________________
    public ReservationEntity createReservationNtt(ReservationFromDTOtoNTT reservationFromDTOtoNTT) {

        ReservationEntity mappedNtt = prepareReservationDetails(reservationFromDTOtoNTT);

        if (hotelHasRoomsRepository.getRoomNumbersForValidation(mappedNtt.getHotel().getHotelId(), mappedNtt.getRoomType().getRoomTypeId())
                <= reservationRepository.getReservationValidation(mappedNtt.getHotel().getHotelId(), mappedNtt.getRoomType().getRoomTypeId(), mappedNtt.getCheckIn(), mappedNtt.getCheckOut())) {
            throw new ReservationNotPossibleException("All rooms in the selected category have been booked for this hotel in the selected interval. " +
                    "Please select a different period or another room type.");
        } else {
            return reservationRepository.save(mappedNtt);
        }

    }

    private ReservationEntity prepareReservationDetails(ReservationFromDTOtoNTT reservationFromDTOtoNTT) {
        CustomerEntity customerEntity = customerRepository.findByCustomerId(reservationFromDTOtoNTT.getCustomerId());
        HotelEntity hotelEntity = hotelRepository.findByHotelId(reservationFromDTOtoNTT.getHotel());
        RoomTypeEntity roomTypeEntity = roomTypeRepository.findByRoomTypeId(reservationFromDTOtoNTT.getRoomType());
        HotelHasRoomsEntity hotelHasRoomsEntity = hotelHasRoomsRepository.findById(new HotelHasRoomCompositPK(hotelEntity.getHotelId(), roomTypeEntity.getRoomTypeId())).orElseThrow();

        int reservationNumberOfDays = (int) ChronoUnit.DAYS.between(reservationFromDTOtoNTT.getCheckIn(), reservationFromDTOtoNTT.getCheckOut());
        double reservationPriceBeforeDiscount = reservationNumberOfDays * hotelHasRoomsEntity.getPricePerNight();
        double reservationPriceWithDiscount = reservationPriceBeforeDiscount - (reservationPriceBeforeDiscount * customerEntity.getLoyaltyLevel().getDiscountPercent() / 100);


        if (reservationRepository.checkForDuplicates(customerEntity.getCustomerId(), hotelEntity.getHotelId(), roomTypeEntity.getRoomTypeId(), reservationFromDTOtoNTT.getCheckIn(), reservationFromDTOtoNTT.getCheckOut()) != null) {
            throw new ReservationNotPossibleException("A duplicate reservation was detected. Please check your reservation details" +
                    reservationNttToDtoMapper.createDTOFromNTT(reservationRepository.checkForDuplicates(customerEntity.getCustomerId(),
                            hotelEntity.getHotelId(), roomTypeEntity.getRoomTypeId(), reservationFromDTOtoNTT.getCheckIn(),
                            reservationFromDTOtoNTT.getCheckOut())));
        } else {
            return getMappedReservationNtt(reservationFromDTOtoNTT, customerEntity, hotelEntity, roomTypeEntity, reservationPriceWithDiscount);
        }
    }

    private ReservationEntity getMappedReservationNtt(ReservationFromDTOtoNTT reservationFromDTOtoNTT,
                                                      CustomerEntity customerEntity, HotelEntity hotelEntity,
                                                      RoomTypeEntity roomTypeEntity, double reservationPriceWithDiscount) {
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
    //---------------------------------------------------------------


    @SneakyThrows
    public List<ReservationCreateNewDto> createBulkReservationsFromFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ReservationNotPossibleException("The provided file is empty or corrupted. Please check your file and try again!");
        }
        byte[] bytes = file.getBytes();
        String fileContent = new String(bytes);
        String[] rows = fileContent.split("\r\n");

        List<ReservationFromDTOtoNTT> toCreate = new ArrayList<>();

        for (String row : rows) {
            String[] rowSplit = row.split(",");
            if (rowSplit.length != 0) {
                ReservationFromDTOtoNTT reservationFromDTOtoNTT = ReservationFromDTOtoNTT.builder()
                        .customerId(Integer.parseInt(rowSplit[0]))
                        .hotel(Integer.parseInt(rowSplit[1]))
                        .roomType(Integer.parseInt(rowSplit[2]))
                        .checkIn(LocalDate.parse(rowSplit[3]))
                        .checkOut(LocalDate.parse(rowSplit[4]))
                        .build();
                toCreate.add(reservationFromDTOtoNTT);
            }
        }
        return createReservationNttFromList(toCreate);
    }

    public List<ReservationCreateNewDto> createReservationNttFromList(List<ReservationFromDTOtoNTT> toCreate) {
        return toCreate.stream()
                .map(this::createReservationNtt)
                .map(reservationRepository::save)
                .map(reservationNttToDtoMapper::createDTOFromNTT)
                .collect(toList());
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void checkForReservationsThatHaveEnded() {

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
