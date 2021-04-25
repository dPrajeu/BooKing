package siit.hotel_booking_web_app.mapper.hotel;

import org.springframework.stereotype.Component;
import siit.hotel_booking_web_app.model.dto.hotel_dto.HotelCreateDto;
import siit.hotel_booking_web_app.model.entities.HotelEntity;

@Component
public class HotelDtoToNttMapper {

    public HotelEntity mapNttToDto(HotelCreateDto hotelCreateDto) {

        return HotelEntity.builder()
                .hotelName(hotelCreateDto.getHotelName())
                .phoneNumber(hotelCreateDto.getPhoneNumber())
                .hotelEmail(hotelCreateDto.getHotelEmail())
                .country(hotelCreateDto.getCountry())
                .city(hotelCreateDto.getCity())
                .address(hotelCreateDto.getAddress())
                .rating(hotelCreateDto.getRating())
                .build();
    }
}
