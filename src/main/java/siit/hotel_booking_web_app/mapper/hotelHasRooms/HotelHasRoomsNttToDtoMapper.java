package siit.hotel_booking_web_app.mapper.hotelHasRooms;

import org.springframework.stereotype.Component;

import siit.hotel_booking_web_app.model.dto.hotelHasRoomsDto.HotelHasRoomsRequestDto;
import siit.hotel_booking_web_app.model.entities.HotelHasRoomsEntity;

@Component
public class HotelHasRoomsNttToDtoMapper {
    public HotelHasRoomsRequestDto mapNttToDto(HotelHasRoomsEntity ntt) {

        return HotelHasRoomsRequestDto.builder()
//                .hotelWithRooms(HotelHasRoomCompositPK.builder()
//                        .hotelId(ntt.getHotelId().getHotelId())
//                        .roomType(ntt.getRoomType().getRoomTypeId())
//                        .build())
                .hotelId(ntt.getHotelId().getHotelId())
                .hotelName(ntt.getHotelId().getHotelName())
                .roomTypeId(ntt.getRoomType().getRoomTypeId())
                .roomTypeName(ntt.getRoomType().getRoomType())
                .roomQuantity(ntt.getRoomQuantity())
                .pricePerNight(ntt.getPricePerNight())
                .build();
    }


//    public HotelHasRoomsRequestDto mapNttToDtoGetById(HotelHasRoomsEntity ntt) {
//
//        return HotelHasRoomsRequestDto.builder()
//                .hotelWithRooms(HotelHasRoomCompositPK.builder()
//                        .hotelId(ntt.getHotelId().getHotelId())
//                        .roomType(ntt.getRoomType().getRoomTypeId())
//                        .build())
//                .hotelId(ntt.getHotelId().getHotelId())
//                .hotelName(ntt.getHotelId().getHotelName())
//                .roomTypeId(ntt.getRoomType().getRoomTypeId())
//                .roomTypeName(ntt.getRoomType().getRoomType())
//                .roomQuantity(ntt.getRoomQuantity())
//                .pricePerNight(ntt.getPricePerNight())
//                .build();
//    }
}
