package siit.hotel_booking_web_app.hotel.serviceTests;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import siit.hotel_booking_web_app.exceptions.hotel.HotelNotFoundException;
import siit.hotel_booking_web_app.mapper.hotel.HotelDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.hotel.HotelNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.hotel_dto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotel_dto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotel_dto.HotelRequestWithFilteredRoomDetailsDTO;
import siit.hotel_booking_web_app.model.dto.hotel_dto.HotelUpdateDto;
import siit.hotel_booking_web_app.model.dto.hotel_has_rooms_dto.HotelHasRoomsRequestWithoutHotelDetailsDTO;
import siit.hotel_booking_web_app.model.entities.*;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;
import siit.hotel_booking_web_app.repository.RoomTypeRepository;
import siit.hotel_booking_web_app.service.HotelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceTests {

    @InjectMocks
    private HotelService hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private HotelNttToDtoMapper hotelNttToDtoMapper;

    @Mock
    private HotelDtoToNttMapper hotelDtoToNttMapper;

    @Mock
    private HotelHasRoomsRepository hotelHasRoomsRepository;

    @Mock
    private RoomTypeRepository roomTypeRepository;

    private List<HotelEntity> HOTEL_NTT_LIST = new ArrayList<>();
    private List<HotelHasRoomsEntity> HOTEL_ROOMS_LIST = new ArrayList<>();
    private List<HotelRequestWithFilteredRoomDetailsDTO> HOTEL_REQUEST_DTO_FILTERED_LIST = new ArrayList<>();
    private List<HotelHasRoomsRequestWithoutHotelDetailsDTO> HOTEL_HAS_ROOMS_REQUEST_DTO_FILTERED_LIST = new ArrayList<>();

    private HotelHasRoomCompositPK HOTEL_ROOMS_PK = HotelHasRoomCompositPK.builder()
            .hotelId(1)
            .roomType(1)
            .build();

    private HotelHasRoomsEntity HOTEL_ROOMS_ENTITY = HotelHasRoomsEntity.builder()
            .hotelWithRooms(HOTEL_ROOMS_PK)
            .build();


    private HotelEntity HOTEL_ENTITY = HotelEntity.builder()
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

    private HotelRequestDto HOTEL_REQUEST_DTO = HotelRequestDto.builder()
            .hotelId(1)
            .hotelName("La Mishu")
            .address("Vulturului")
            .city("Braila")
            .country("Romania")
            .hotelEmail("mishu@mishu.mishu")
            .phoneNumber("0215634")
            .rating(2)
            .hotelHasRoomsEntitiesList(HOTEL_ROOMS_LIST)
            .build();

    private HotelRequestWithFilteredRoomDetailsDTO HOTEL_REQUEST_DTO_FILTERED = HotelRequestWithFilteredRoomDetailsDTO.builder()
            .hotelId(1)
            .hotelName("La Mishu")
            .address("Vulturului")
            .city("Braila")
            .country("Romania")
            .hotelEmail("mishu@mishu.mishu")
            .phoneNumber("0215634")
            .rating(2)
            .hotelHasRoomsRequestWithoutHotelDetailsDTOS(HOTEL_HAS_ROOMS_REQUEST_DTO_FILTERED_LIST)
            .build();

    private HotelHasRoomsRequestWithoutHotelDetailsDTO HOTEL_HAS_ROOMS_REQUEST_DTO_FILTERED = HotelHasRoomsRequestWithoutHotelDetailsDTO.builder()
            .roomTypeId(2)
            .roomTypeName("Double")
            .roomQuantity(50)
            .pricePerNight(20.20)
            .build();

    private final HotelCreateDto HOTEL_CREATE_DTO = HotelCreateDto.builder()
            .hotelName("La Mishu")
            .address("Vulturului")
            .city("Braila")
            .country("Romania")
            .hotelEmail("mishu@mishu.mishu")
            .phoneNumber("0215634")
            .rating(2)
            .hotelHasRoomsEntitiesList(HOTEL_ROOMS_LIST)
            .build();


    @Test
    public void getAllHotels_givenNoHotels_thenReturnEmptyList() {

        when(hotelRepository.findAll()).thenReturn(Lists.emptyList());

        var allHotels = hotelService.returnAll();

        assertThat(allHotels).isNotNull();
        assertThat(allHotels.isEmpty()).isTrue();
    }

    @Test
    public void getAllHotels_givenExistingHotel_thenReturnHotelList() {

        List<HotelEntity> hotelEntities = new ArrayList<>();
        hotelEntities.add(HOTEL_ENTITY);
        hotelEntities.add(HOTEL_ENTITY);
        hotelEntities.add(HOTEL_ENTITY);

        when(hotelRepository.findAll()).thenReturn(hotelEntities);
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        var allHotels = hotelService.returnAll();

        assertThat(allHotels).isNotNull();
        assertThat(allHotels.size()).isEqualTo(3);
        assertThat(allHotels.get(0)).isNotNull();
        assertThat(allHotels.get(0).getCity()).isEqualTo(HOTEL_ENTITY.getCity());
    }

    @Test
    public void getHotelDetails_givenExistingHotelId_thenReturnHotelDetails() {

        when(hotelRepository.findById(1)).thenReturn(Optional.ofNullable(HOTEL_ENTITY));
        assert HOTEL_ENTITY != null;
        when(hotelNttToDtoMapper.mapNttToDtoSecond(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO_FILTERED);

        HotelRequestWithFilteredRoomDetailsDTO hotelRequestWithFilteredRoomDetailsDTO = hotelService.hotelById(1);

        assertThat(hotelRequestWithFilteredRoomDetailsDTO).isNotNull().isEqualTo(HOTEL_REQUEST_DTO_FILTERED);
    }

    @Test
    public void getHotelDetails_givenInvalidHotelId_thenReturnException() {

        Integer hotelId = 1;

        when(hotelRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.catchThrowable(() -> hotelService.hotelById(hotelId));

        assertThat(throwable).isInstanceOf(HotelNotFoundException.class);
    }

    @Test
    public void getHotelDetails_givenExistingHotelId_thenReturnHotelWithCompleteDetails() {

        when(hotelRepository.findById(1)).thenReturn(Optional.ofNullable(HOTEL_ENTITY));
        assert HOTEL_ENTITY != null;
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        HotelRequestDto hotelRequestDto = hotelService.hotelWithAllDetailsById(1);

        assertThat(hotelRequestDto).isNotNull().isEqualTo(HOTEL_REQUEST_DTO);
    }

    @Test
    public void getHotelList_givenCountry_thenReturnHotelListFromGivenCountry() {

        String country = "Romania";

        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);

        when(hotelRepository.findAllByCountry(ArgumentMatchers.any())).thenReturn(HOTEL_NTT_LIST);
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        var allHotels = hotelService.returnAllByCountry(country);

        assertThat(allHotels).isNotNull();
        assertThat(allHotels.size()).isEqualTo(3);
        assertThat(allHotels.get(1).getCountry()).isEqualTo(HOTEL_ENTITY.getCountry());
        assertThat(allHotels.get(1).getCity()).isEqualTo(HOTEL_ENTITY.getCity());
        assertThat(allHotels.get(1).getAddress()).isEqualTo(HOTEL_ENTITY.getAddress());
    }

    @Test
    public void getHotelList_givenCity_thenReturnHotelListFromGivenCity() {

        String city = "Braila";

        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);

        when(hotelRepository.findAllByCity(ArgumentMatchers.any())).thenReturn(HOTEL_NTT_LIST);
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        var allHotels = hotelService.returnAllByCity(city);

        assertThat(allHotels).isNotNull();
        assertThat(allHotels.size()).isEqualTo(3);
        assertThat(allHotels.get(1).getHotelId()).isEqualTo(HOTEL_ENTITY.getHotelId());
        assertThat(allHotels.get(1).getHotelName()).isEqualTo(HOTEL_ENTITY.getHotelName());
        assertThat(allHotels.get(1).getHotelEmail()).isEqualTo(HOTEL_ENTITY.getHotelEmail());
        assertThat(allHotels.get(1).getCountry()).isEqualTo(HOTEL_ENTITY.getCountry());
        assertThat(allHotels.get(1).getCity()).isEqualTo(HOTEL_ENTITY.getCity());
        assertThat(allHotels.get(1).getAddress()).isEqualTo(HOTEL_ENTITY.getAddress());
        assertThat(allHotels.get(1).getHotelHasRoomsEntitiesList()).isEqualTo(HOTEL_ENTITY.getHotelHasRoomsEntityList());
    }

    @Test
    public void getHotelsDetails_givenvalidRating_thenReturnHotelList() {

        new HotelEntity();
        HotelEntity hotel2 = HotelEntity.builder()
                .hotelId(2)
                .rating(4)
                .build();
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(HOTEL_ENTITY);
        HOTEL_NTT_LIST.add(hotel2);

        when(hotelRepository.findAllByRating(ArgumentMatchers.any())).thenReturn(HOTEL_NTT_LIST);
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        var allHotels = hotelService.returnAllByRating(2);

        assertThat(allHotels).isNotNull();
        assertThat(allHotels.size()).isEqualTo(5);
        assertThat(allHotels.get(1).getHotelId()).isEqualTo(HOTEL_ENTITY.getHotelId());
        assertThat(allHotels.get(1).getHotelName()).isEqualTo(HOTEL_ENTITY.getHotelName());
        assertThat(allHotels.get(1).getHotelEmail()).isEqualTo(HOTEL_ENTITY.getHotelEmail());
        assertThat(allHotels.get(1).getCountry()).isEqualTo(HOTEL_ENTITY.getCountry());
        assertThat(allHotels.get(1).getCity()).isEqualTo(HOTEL_ENTITY.getCity());
        assertThat(allHotels.get(1).getAddress()).isEqualTo(HOTEL_ENTITY.getAddress());
        assertThat(allHotels.get(1).getHotelHasRoomsEntitiesList()).isEqualTo(HOTEL_ENTITY.getHotelHasRoomsEntityList());
    }

    //    @Test
//    public void createHotelNtt_givenCorrectHotelDetails_thenReturnNewHotelCreateDto() {
//
//        when(hotelDtoToNttMapper.mapNttToDto(HOTEL_CREATE_DTO)).thenReturn(HOTEL_ENTITY);
//        when(hotelRepository.save(HOTEL_ENTITY)).thenReturn(HOTEL_ENTITY);
//        when(roomTypeRepository.getOne(HOTEL_ROOMS_ENTITY.getRoomType().getRoomTypeId())).thenReturn(ROOM_TYPE);
//        when(hotelHasRoomsRepository.save(HOTEL_ROOMS_ENTITY)).thenReturn(HOTEL_ROOMS_ENTITY);
//
//        HotelCreateDto newHotel = hotelService.createHotelNtt(HOTEL_CREATE_DTO);
//
//        assertThat(newHotel).isNotNull();
//        assertThat(newHotel.getCity()).isEqualTo(HOTEL_ENTITY.getCity());
//        assertThat(newHotel.getHotelName()).isEqualTo(HOTEL_ENTITY.getHotelName());
//    }

    @Test
    public void updateHotelDetails_givenNewValues_returnNewHotelDetails() {

        HotelUpdateDto hotelUpdateDto = HotelUpdateDto.builder()
                .phoneNumber("0722222222")
                .country("India")
                .city("Mumbai")
                .rating(1)
                .build();

        when(hotelRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(HOTEL_ENTITY));
        when(hotelNttToDtoMapper.mapNttToDto(HOTEL_ENTITY)).thenReturn(HOTEL_REQUEST_DTO);

        var result = hotelService.updateHotelNtt(hotelUpdateDto);

        assertThat(result).isNotNull()
                .isSameAs(HOTEL_REQUEST_DTO);
    }
}
