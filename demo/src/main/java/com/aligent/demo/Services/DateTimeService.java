package com.aligent.demo.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class DateTimeService {

    public long getDaysBetween(LocalDateTime start, LocalDateTime end, String zoneId) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return -1;
        }
        return ChronoUnit.DAYS.between(start, end);
    }

    public long getWeekDaysBetween(LocalDateTime start, LocalDateTime end, String zoneId) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return -1;
        }
        long days = ChronoUnit.DAYS.between(start, end);
        long weekDays = 0;
        for (int i = 0; i < days; i++) {
            LocalDateTime date = start.plusDays(i);
            if (date.getDayOfWeek().getValue() < 6) {
                weekDays++;
            }
        }
        return weekDays;
    }

    public long getCompleteWeeksBetween(LocalDateTime start, LocalDateTime end, String zoneId) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return -1;
        }
        long days = ChronoUnit.DAYS.between(start, end);
        return days / 7;
    }
}
