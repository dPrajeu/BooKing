package siit.hotel_booking_web_app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siit.hotel_booking_web_app.model.dto.reservationDto.ReservationRequestDto;
import siit.hotel_booking_web_app.service.ReservationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/reservationsdb")
public class ReservationsController {
    private final ReservationService reservationService;

    //get all reservations in database
    //http://localhost:8080/front_page/reservationsdb/get_all_reservations
    @RequestMapping(value = "/get_all_reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getAllReservations() {
        return reservationService.findAllReservations();
    }

    //get reservation by ID
    //http://localhost:8080/front_page/reservationsdb/reservationId?reservationId=1
    @RequestMapping(value = "/reservationId{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationById(@RequestParam(name = "reservationId") Integer reservationId) {
        return reservationService.findReservationById(reservationId);
    }


    //get reservation by ID
    //http://localhost:8080/front_page/reservationsdb/reservation_for_customer?customerId=4
    @RequestMapping(value = "/reservation_for_customer{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByCustomerId(@RequestParam(name = "customerId") Integer customerId) {
        return reservationService.findReservationByCustomerId(customerId);
    }

    //get reservation by Hotel
    //http://localhost:8080/front_page/reservationsdb/reservation_for_hotel?hotelId=4
    @RequestMapping(value = "/reservation_for_hotel{hotel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByHotel(@RequestParam(name = "hotel") Integer hotel) {

        return reservationService.findReservationByHotel(hotel);

    }

    //get reservation by Hotel and customerId
    //http://localhost:8080/front_page/reservationsdb/reservation_by_?hotelId=4/?customerId=
    @RequestMapping(value = "/reservation_by_{hotel}{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByHotelAndCustomerId(@RequestParam(name = "hotel") Integer hotel, @RequestParam (name ="customerId") Integer customerId) {

        return reservationService.findAllReservationsByHotelOrCustomer(hotel, customerId);

    }
}
