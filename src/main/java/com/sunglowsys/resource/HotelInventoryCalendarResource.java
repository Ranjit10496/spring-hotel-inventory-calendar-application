package com.sunglowsys.resource;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.service.HotelInventoryCalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelInventoryCalendarResource {
    private final Logger logger = LoggerFactory.getLogger(HotelInventoryCalendarResource.class);
    private final HotelInventoryCalendarService hotelInventoryCalendarService;

    public HotelInventoryCalendarResource(HotelInventoryCalendarService hotelInventoryCalendarService) {
        this.hotelInventoryCalendarService = hotelInventoryCalendarService;
    }
    @PostMapping("/hotel-inventory-calendars")
    public ResponseEntity<HotelInventoryCalendar> createHotelInventoryCalendar(HotelInventoryCalendar hotelInventoryCalendar) {
        logger.debug("request to creat hotelInventoryCalendar:{}",hotelInventoryCalendar);
        HotelInventoryCalendar result = hotelInventoryCalendarService.save(hotelInventoryCalendar);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/hotel-inventory-calendars")
    public ResponseEntity<HotelInventoryCalendar> updateHotelInventoryCalendar(HotelInventoryCalendar hotelInventoryCalendar){
        logger.debug("request to update hotelInventoryCalendar:{}",hotelInventoryCalendar);
        if (hotelInventoryCalendar.getId()==null) {
            throw new RuntimeException("it not be must null");
        }
        HotelInventoryCalendar result = hotelInventoryCalendarService.update(hotelInventoryCalendar);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/hotel-inventory-calendars")
    public ResponseEntity<Page<HotelInventoryCalendar>> findAllhotelInventoryCalendar(Pageable pageable){
        logger.debug("request to findAll hotelInventoryCalenda:{}",pageable );
        Page<HotelInventoryCalendar> result = hotelInventoryCalendarService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/hotel-inventory-calendars/{id}")
    public ResponseEntity<Optional<HotelInventoryCalendar>> findOneHotelInventoryCalendar(Long id){
        logger.debug("request to findOne hotelInventoryCalendar:{}",id);
        Optional<HotelInventoryCalendar> result = hotelInventoryCalendarService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    public ResponseEntity<Void> deleteHoteelInventoryCalendar(Long id) {
        logger.debug("request to delete hotelInventoryCalendar:{}",id);
        hotelInventoryCalendarService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
