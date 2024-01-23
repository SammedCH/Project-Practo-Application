package com.practo.practo.service;

import com.practo.practo.config.TimeSlotManager;
import com.practo.practo.entities.Booking;
import com.practo.practo.payLoad.BookingDto;
import com.practo.practo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private TimeSlotManager timeSlotManager;

    public void bookAnAppointment(BookingDto dto) {
     List<String> availabletimeSlots=timeSlotManager.getAvailableTimeSlots();

        Booking booking = new Booking();
        for (String slots : availabletimeSlots) {
            if (slots.equals(dto.getBookingTime())) {
                booking.setBookingTime(dto.getBookingTime());
                availabletimeSlots.remove(slots);
                timeSlotManager.setAvailableTimeSlots(availabletimeSlots);

            }
        }

        ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
                executor.scheduleAtFixedRate(() -> {
                            System.out.println("Executing code every 24 hours...");
                    availabletimeSlots.add("10:15 AM");
                    availabletimeSlots.add("11:15 AM");
                    availabletimeSlots.add("12:15 PM");
                        },0,24, TimeUnit.HOURS);
        booking.setDoctorId(dto.getDoctorId());
        booking.setBookingTime(dto.getBookingTime());

        if (booking.getBookingTime() != null) {
            bookingRepo.save(booking);
        }else{
            System.out.println("Time slot not Available");
        }
    }
}