package siit.hotel_booking_web_app.hotel_has_rooms;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import siit.hotel_booking_web_app.mapper.hotel_has_rooms.HotelHasRoomsNttToDtoMapper;
import siit.hotel_booking_web_app.repository.HotelHasRoomsRepository;
import siit.hotel_booking_web_app.repository.HotelRepository;
import siit.hotel_booking_web_app.service.HotelHasRoomsService;

@RunWith(MockitoJUnitRunner.class)
public class hotelHasRoomsServiceTests {
    @InjectMocks
    HotelHasRoomsService hotelHasRoomsService;

    @Mock
    private HotelHasRoomsRepository hotelHasRoomsRepository;
    @Mock
    private HotelHasRoomsNttToDtoMapper hotelHasRoomsNttToDtoMapper;
    @Mock
    private HotelRepository hotelRepository;




}
