package siit.hotel_booking_web_app.exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String s) {
        super(s);
    }
}
