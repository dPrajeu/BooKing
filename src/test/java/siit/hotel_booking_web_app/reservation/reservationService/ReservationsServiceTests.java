package siit.hotel_booking_web_app.reservation.reservationService;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import siit.hotel_booking_web_app.mapper.reservation.ReservationNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.*;
import siit.hotel_booking_web_app.repository.*;
import siit.hotel_booking_web_app.service.ReservationService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationsServiceTests {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ReservationNttToDtoMapper reservationNttToDtoMapper;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private ReservationStatusRepository reservationStatusRepository;

    private List<HotelHasRoomsEntity> HOTEL_ROOMS_LIST = new ArrayList<>();
    private List<ReservationEntity> RESERVATIONS_LIST = new ArrayList<>();

    private final CustomerLoyaltyEntity CUSTOMER_LOYALTY = CustomerLoyaltyEntity.builder()
            .loyaltyId(1)
            .loyaltyLevelName("Unranked")
            .discountPercent(0)
            .build();

    private final CustomerEntity CUSTOMER_ENTITY = CustomerEntity.builder()
            .customerId(1)
            .firstName("Florin")
            .lastName("Piersic")
            .socialId("ZV123123")
            .customerEmail("piersic@piersic.piersic")
            .phoneNumber("123123123")
            .birthDate("20/10/1954")
            .city("Brasov")
            .address("Piersic street")
            .loyaltyLevel(CUSTOMER_LOYALTY)
            .build();

    private final HotelEntity HOTEL_ENTITY = HotelEntity.builder()
            .hotelId(1)
            .hotelName("La Mishu")
            .address("Vulturului")
            .city("Braila")
            .country("Romania")
            .hotelEmail("mishu@mishu.mishu")
            .phoneNumber("0215634")
            .rating(2)
            .hotelHasRoomsEntityList(HOTEL_ROOMS_LIST)
            .build();

    private final RoomTypeEntity ROOM_TYPE = RoomTypeEntity.builder()
            .roomTypeId(2)
            .roomType("Double")
            .build();

    private final ReservationStatusEntity STATUS = ReservationStatusEntity.builder()
            .statusId(1)
            .statusName("Requested")
            .build();

    private final ReservationEntity RESERVATION_NTT = ReservationEntity.builder()
            .reservationId(1)
            .customerId(CUSTOMER_ENTITY)
            .hotel(HOTEL_ENTITY)
            .roomType(ROOM_TYPE)
            .checkIn(LocalDate.of(2019, 10, 10))
            .checkOut(LocalDate.of(2019, 10, 17))
            .priceTotal(200.50)
            .discountPercent(2)
            .status(STATUS)
            .build();

    private static final ReservationRequestDto RESERVATION_REQUEST_DTO = ReservationRequestDto.builder()
            .reservationId(1)
            .customerName("Florin Piersic")
            .hotelId(1)
            .hotelName("La Mishu")
            .roomTypeId(2)
            .roomTypeName("Double")
            .pricePerNight(28.642857142857142)
            .checkIn(LocalDate.of(2019, 10, 10))
            .checkOut(LocalDate.of(2019, 10, 17))
            .priceTotal(200.50)
            .discountPercent(2)
            .status("Requested")
            .build();

    @Test
    public void getAllReservations_givenNoReservations_thenReturnEmptyList() {

        when(reservationRepository.findAll()).thenReturn(Lists.emptyList());

        var allReservations = reservationService.findAllReservations();

        assertThat(allReservations).isNotNull();
        assertThat(allReservations.isEmpty()).isTrue();
    }

    @Test
    public void getAllReservations_givenExistingReservations_thenReturnReservationsList() {

        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);

        when(reservationRepository.findAll()).thenReturn(RESERVATIONS_LIST);
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATION_NTT)).thenReturn(RESERVATION_REQUEST_DTO);

        var allReservations = reservationService.findAllReservations();

        assertThat(allReservations).isNotNull();
        assertThat(allReservations.size()).isEqualTo(3);
        assertThat(allReservations.get(0)).isNotNull();
        assertThat(allReservations.get(0).getReservationId()).isEqualTo(RESERVATION_NTT.getReservationId());
        assertThat(allReservations.get(0).getCheckIn()).isEqualTo(RESERVATION_NTT.getCheckIn());
        assertThat(allReservations.get(0).getCheckOut()).isEqualTo(RESERVATION_NTT.getCheckOut());
        assertThat(allReservations.get(0).getDiscountPercent()).isEqualTo(RESERVATION_NTT.getDiscountPercent());
        assertThat(allReservations.get(0).getRoomTypeId()).isEqualTo(RESERVATION_NTT.getRoomType().getRoomTypeId());
        assertThat(allReservations.get(0).getCustomerName()).isEqualTo(RESERVATION_NTT.getCustomerId().getFirstName().concat(" " + RESERVATION_NTT.getCustomerId().getLastName()));
        assertThat(allReservations.get(0).getHotelName()).isEqualTo(RESERVATION_NTT.getHotel().getHotelName());
        assertThat(allReservations.get(0).getHotelId()).isEqualTo(RESERVATION_NTT.getHotel().getHotelId());
        assertThat(allReservations.get(0).getPricePerNight()).isEqualTo(RESERVATION_NTT.getPriceTotal() / (int) ChronoUnit.DAYS.between(RESERVATION_NTT.getCheckIn(), RESERVATION_NTT.getCheckOut()));
    }

    @Test
    public void getReservation_givenExistingReservationId_thenReturnReservationDetails() {

        when(reservationRepository.findById(1)).thenReturn(Optional.ofNullable(RESERVATION_NTT));
        assert RESERVATION_NTT != null;
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATION_NTT)).thenReturn(RESERVATION_REQUEST_DTO);

        List<ReservationRequestDto> reservationRequestDtoList = reservationService.findReservationById(1);

        assertThat(reservationRequestDtoList).isNotNull();
        assertThat(reservationRequestDtoList.get(0)).isEqualTo(RESERVATION_REQUEST_DTO);
    }

    @Test
    public void getReservation_givenCustomerId_thenReturnReservationDetails() {

        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);

        when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(CUSTOMER_ENTITY));
        when(reservationRepository.findByCustomerId(CUSTOMER_ENTITY)).thenReturn(RESERVATIONS_LIST);
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATIONS_LIST.get(0))).thenReturn(RESERVATION_REQUEST_DTO);

        List<ReservationRequestDto> reservationRequestDtoList = reservationService.findReservationByCustomerId(1);

        assertThat(reservationRequestDtoList).isNotNull();
        assertThat(reservationRequestDtoList.get(0)).isEqualTo(RESERVATION_REQUEST_DTO);
    }

    @Test
    public void getReservation_givenHotelId_thenReturnReservationDetails() {

        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);

        when(hotelRepository.findById(1)).thenReturn(Optional.ofNullable(HOTEL_ENTITY));
        when(reservationRepository.findByHotel(HOTEL_ENTITY)).thenReturn(RESERVATIONS_LIST);
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATIONS_LIST.get(0))).thenReturn(RESERVATION_REQUEST_DTO);

        List<ReservationRequestDto> reservationRequestDtoList = reservationService.findReservationByHotel(1);

        assertThat(reservationRequestDtoList).isNotNull();
        assertThat(reservationRequestDtoList.get(0)).isEqualTo(RESERVATION_REQUEST_DTO);
    }


    @Test
    public void getReservation_givenHotelIdAndCustomerID_thenReturnReservationList() {

        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);

        when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(CUSTOMER_ENTITY));
        when(hotelRepository.findById(1)).thenReturn(Optional.ofNullable(HOTEL_ENTITY));
        when(reservationRepository.findByHotel(HOTEL_ENTITY)).thenReturn(RESERVATIONS_LIST);
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATIONS_LIST.get(0))).thenReturn(RESERVATION_REQUEST_DTO);

        List<ReservationRequestDto> reservationRequestDtoList = reservationService.findAllReservationsFromHotelForCustomer(1, 1);

        assertThat(reservationRequestDtoList).isNotNull();
        assertThat(reservationRequestDtoList.size()).isEqualTo(3);
        assertThat(reservationRequestDtoList.get(0)).isEqualTo(RESERVATION_REQUEST_DTO);
    }

    @Test
    public void getReservation_givenReservationStatus_thenReturnReservationList() {

        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);
        RESERVATIONS_LIST.add(RESERVATION_NTT);

        when(reservationStatusRepository.findById(1)).thenReturn(Optional.ofNullable(STATUS));
        when(reservationRepository.findAllByStatus(STATUS)).thenReturn(RESERVATIONS_LIST);
        when(reservationNttToDtoMapper.mapNttToDto(RESERVATIONS_LIST.get(0))).thenReturn(RESERVATION_REQUEST_DTO);

        List<ReservationRequestDto> reservationRequestDtoList = reservationService.findReservationsByStatus(1);

        assertThat(reservationRequestDtoList).isNotNull();
        assertThat(reservationRequestDtoList.size()).isEqualTo(3);
        assertThat(reservationRequestDtoList.get(0)).isEqualTo(RESERVATION_REQUEST_DTO);
    }


}
