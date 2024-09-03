package com.aligent.demo.Controllers;

import com.aligent.demo.Services.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/datetime")
public class DateTimeController {

    @Autowired
    private DateTimeService dateTimeService;

    @RequestMapping("/daysBetween")
    public long getDaysBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String zoneId
    ) {

        return dateTimeService.getDaysBetween(start, end, zoneId);
    }

    @RequestMapping("/weekDaysBetween")
    public long getWeekDaysBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String zoneId
    ) {

        return dateTimeService.getWeekDaysBetween(start, end, zoneId);
    }

    @RequestMapping("/completeWeeksBetween")
    public long getCompleteWeeksBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String zoneId
    ) {

        return dateTimeService.getCompleteWeeksBetween(start, end, zoneId);
    }
}
