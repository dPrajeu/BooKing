package siit.hotel_booking_web_app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationCreateNewDto;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationFromDTOtoNTT;
import siit.hotel_booking_web_app.model.dto.reservation_dto.ReservationRequestDto;
import siit.hotel_booking_web_app.model.entities.ReservationEntity;
import siit.hotel_booking_web_app.service.ReservationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/front_page/reservationsdb")
public class ReservationsController {
    private final ReservationService reservationService;


    //===========================------------------- GET Requests  -----------------===============================
    //get all reservations in database
    //http://localhost:8080/front_page/reservationsdb/get_all_reservations
    @RequestMapping(value = "/get_all_reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getAllReservations() {
        return reservationService.findAllReservations();
    }

    //get reservation by ReservationID
    //http://localhost:8080/front_page/reservationsdb/reservationId?reservationId=1
    @RequestMapping(value = "/reservationId", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationById(@RequestParam(name = "reservationId") Integer reservationId) {
        return reservationService.findReservationById(reservationId);
    }


    //get all reservations for CustomerID
    //http://localhost:8080/front_page/reservationsdb/reservation_for_customer?customerId=4
    @RequestMapping(value = "/reservation_for_customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByCustomerId(@RequestParam(name = "customerId") Integer customerId) {
        return reservationService.findReservationByCustomerId(customerId);
    }

    //get reservation by Hotel
    //http://localhost:8080/front_page/reservationsdb/reservation_for_hotel?hotelId=25
    @RequestMapping(value = "/reservation_for_hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByHotel(@RequestParam(name = "hotelId") Integer hotelId) {

        return reservationService.findReservationByHotel(hotelId);

    }

    //get reservation by Hotel and customerId
    //http://localhost:8080/front_page/reservationsdb/return_reservation_?hotel=25&customerId=35
    @RequestMapping(value = "/return_reservation_", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsFromHotelForCustomerId(@RequestParam(name = "hotel") Integer hotel, @RequestParam(name = "customerId") Integer customerId) {

        return reservationService.findAllReservationsFromHotelForCustomer(hotel, customerId);
    }

    //get reservation by Reservation status
    //http://localhost:8080/front_page/reservationsdb/reservation_by_?status=2
    @RequestMapping(value = "/reservation_by_", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationRequestDto> getReservationsByStatus(@RequestParam(name = "status") Integer status) {
        return reservationService.findReservationsByStatus(status);
    }


    //===========================------------------- Create   -----------------===============================

    //create a new reservation
    //http://localhost:8080/front_page/reservationsdb/make_a_reservation
    @PostMapping(value = "/make_a_reservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationEntity createAReservation(@RequestBody ReservationFromDTOtoNTT reservationFromDTOtoNTT) {
        return reservationService.createReservationNtt(reservationFromDTOtoNTT);
    }

    //create bulk reservations from file (Note: works with customers registered/already in the database)
    //http://localhost:8080/front_page/reservationsdb/bulk_reservation
    @PostMapping("/bulk_reservation")
    public List<ReservationCreateNewDto> makeBulkReservations(@RequestParam(name="file") MultipartFile file){
        return reservationService.createBulkReservationsFromFile(file);
    }



    //===========================------------------- Update   -----------------===============================

    //update reservation status to Cancelled (cancel reservation)
    //http://localhost:8080/front_page/reservationsdb/cancel_reservation
    @PutMapping(value = "/cancel_reservation/")
    public void cancelReservation(@RequestParam(name = "reservationId") Integer reservationId) {
        reservationService.cancelReservation(reservationId);
    }

}
