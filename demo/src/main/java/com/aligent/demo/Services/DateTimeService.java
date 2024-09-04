package com.aligent.demo.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class DateTimeService {

    public String getDaysBetween(LocalDateTime start, LocalDateTime end, String zoneId, String unit) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return null;
        }
        long days = ChronoUnit.DAYS.between(start, end);
        if (unit != null) {
            return convertTime(days, unit);
        }
        return days + " days";
    }

    public String getWeekDaysBetween(LocalDateTime start, LocalDateTime end, String zoneId, String unit) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return null;
        }
        long days = ChronoUnit.DAYS.between(start, end);
        long weekDays = 0;
        for (int i = 0; i < days; i++) {
            LocalDateTime date = start.plusDays(i);
            if (date.getDayOfWeek().getValue() < 6) {
                weekDays++;
            }
        }
        if (unit != null) {
            return convertTime(weekDays, unit);
        }
        return weekDays + " weekdays";
    }

    public String getCompleteWeeksBetween(LocalDateTime start, LocalDateTime end, String zoneId, String unit) {
        if (start == null || end == null || start.isAfter(end)) {
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date-time parameters.");
            return null;
        }
        long days = ChronoUnit.DAYS.between(start, end);
        if (unit != null) {
            return convertTime(days / 7, unit);
        }
        return days / 7 + " weeks";
    }

    public String convertTime(long value, String unit) {
        if (unit == null) {
            return value + " days";
        } else if (value == 0) {
            return "0 " + unit;
        } else if (value < 0) {
            throw new IllegalArgumentException("Invalid value: " + value);
        }
        return switch (unit.toLowerCase()) {
            case "seconds" -> value * 24 * 60 * 60 + " seconds";
            case "minutes" -> value * 24 * 60 + " minutes";
            case "hours" -> value * 24 + " hours";
            case "years" -> value / 365 + " years";
            default -> throw new IllegalArgumentException("Invalid unit: " + unit);
        };
    }
}
