package siit.hotel_booking_web_app.mapper.hotel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestWithRoomDetailsDTO;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestWithoutHotelDetailsDTO;
import siit.hotel_booking_web_app.model.entities.HotelEntity;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class HotelNttToDtoMapper {


    public HotelRequestDto mapNttToDto(HotelEntity ntt) {

        return HotelRequestDto.builder()
                .hotelId(ntt.getHotelId())
                .hotelName(ntt.getHotelName())
                .phoneNumber(ntt.getPhoneNumber())
                .hotelEmail(ntt.getHotelEmail())
                .country(ntt.getCountry())
                .city(ntt.getCity())
                .address(ntt.getAddress())
                .rating(ntt.getRating())
//                .hotelHasRoomsEntitiesList(ntt.getHotelHasRoomsEntityList())
                .build();
    }

    public HotelCreateDto createDTOfromNtt(HotelEntity hotelEntity) {

        return HotelCreateDto.builder()
                .hotelName(hotelEntity.getHotelName())
                .phoneNumber(hotelEntity.getPhoneNumber())
                .hotelEmail(hotelEntity.getHotelEmail())
                .country(hotelEntity.getCountry())
                .city(hotelEntity.getCity())
                .address(hotelEntity.getAddress())
                .rating(hotelEntity.getRating())
                .hotelHasRoomsEntitiesList(hotelEntity.getHotelHasRoomsEntityList())
                .build();
    }

    public HotelRequestWithRoomDetailsDTO mapNttToDtoSecond(HotelEntity ntt) {

        return HotelRequestWithRoomDetailsDTO.builder()
                .hotelId(ntt.getHotelId())
                .hotelName(ntt.getHotelName())
                .phoneNumber(ntt.getPhoneNumber())
                .hotelEmail(ntt.getHotelEmail())
                .country(ntt.getCountry())
                .city(ntt.getCity())
                .address(ntt.getAddress())
                .rating(ntt.getRating())
                .hotelHasRoomsRequestWithoutHotelDetailsDTOS(ntt.getHotelHasRoomsEntityList().stream()
                        .map(hotelHasRoomsEntity -> HotelHasRoomsRequestWithoutHotelDetailsDTO.builder()
                                .roomTypeId(hotelHasRoomsEntity.getRoomType().getRoomTypeId())
                                .roomTypeName(hotelHasRoomsEntity.getRoomType().getRoomType())
                                .roomQuantity(hotelHasRoomsEntity.getRoomQuantity())
                                .pricePerNight(hotelHasRoomsEntity.getPricePerNight())
                                .build()
                        )
                        .collect(Collectors.toList()))
                .build();

    }
}
