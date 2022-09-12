package com.sunglowsys.service;

import com.sunglowsys.domain.HotelInventoryCalendar;
import com.sunglowsys.repository.HotelInventoryCalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class HotelInventoryCalendarServiceImpl implements HotelInventoryCalendarService{
    private final Logger logger = LoggerFactory.getLogger(HotelInventoryCalendarServiceImpl.class);
    private final HotelInventoryCalendarRepository hotelInventoryCalendarRepository;

    public HotelInventoryCalendarServiceImpl(HotelInventoryCalendarRepository hotelInventoryCalendarRepository) {
        this.hotelInventoryCalendarRepository = hotelInventoryCalendarRepository;
    }

    @Override
    public HotelInventoryCalendar save(HotelInventoryCalendar hotelInventoryCalendar) {
        logger.debug("request to save hotelInventoryCalendar:{}",hotelInventoryCalendar);
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public HotelInventoryCalendar update(HotelInventoryCalendar hotelInventoryCalendar) {
        logger.debug("request to update hotelInventoryCalendar:{}",hotelInventoryCalendar);
        return hotelInventoryCalendarRepository.save(hotelInventoryCalendar);
    }

    @Override
    public Page<HotelInventoryCalendar> findAll(Pageable pageable) {
        logger.debug("request to findAll hotelInventoryCalendar:{}",pageable);
        return hotelInventoryCalendarRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelInventoryCalendar> findOne(Long id) {
        logger.debug("request to findOne hotelInventoryCalendar:{}",id);
        return hotelInventoryCalendarRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.debug("request to delete hotelInventoryCalendar:{}",id);
        hotelInventoryCalendarRepository.deleteById(id);

    }
}
