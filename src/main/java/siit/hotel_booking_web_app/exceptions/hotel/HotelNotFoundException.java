package siit.hotel_booking_web_app.exceptions.hotel;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(String s) {
        super(s);
    }
}
