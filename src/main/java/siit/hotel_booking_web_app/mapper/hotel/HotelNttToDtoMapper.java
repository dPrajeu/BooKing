package siit.hotel_booking_web_app.mapper.hotel;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelCreateDto;
import siit.hotel_booking_web_app.model.dto.hotelDto.HotelRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;

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
                .build();
    }

    public HotelCreateDto createNTTfromDTO(HotelEntity hotelEntity) {

        return HotelCreateDto.builder()
                .hotelName(hotelEntity.getHotelName())
                .phoneNumber(hotelEntity.getPhoneNumber())
                .hotelEmail(hotelEntity.getHotelEmail())
                .country(hotelEntity.getCountry())
                .city(hotelEntity.getCity())
                .address(hotelEntity.getAddress())
                .rating(hotelEntity.getRating())
                .build();
    }
}
