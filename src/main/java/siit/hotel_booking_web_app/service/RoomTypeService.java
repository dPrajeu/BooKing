package siit.hotel_booking_web_app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import siit.hotel_booking_web_app.model.entities.RoomTypeEntity;
import siit.hotel_booking_web_app.repository.RoomTypeRepository;

import java.util.List;
import java.util.stream.Collector;

@Service
@Configurable
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public List<RoomTypeEntity> returnAll() {
        return roomTypeRepository.findAll();
    }

}
