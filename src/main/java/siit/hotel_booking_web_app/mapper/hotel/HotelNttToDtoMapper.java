package siit.hotel_booking_web_app.mapper.hotel;

import org.springframework.stereotype.Component;
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
                .build();
    }
}
