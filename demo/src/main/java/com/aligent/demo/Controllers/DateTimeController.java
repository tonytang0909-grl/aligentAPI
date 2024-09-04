package com.aligent.demo.Controllers;

import com.aligent.demo.Models.CustomDateTime;
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
    public String getDaysBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) String startZoneId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String endZoneId,
            @RequestParam(required = false) String unit
    ) {
        if (startZoneId == null) {
            startZoneId = "UTC";
        }
        if (endZoneId == null) {
            endZoneId = "UTC";
        }
        CustomDateTime startCustom = new CustomDateTime(start, startZoneId);
        CustomDateTime endCustom = new CustomDateTime(end, endZoneId);
        return dateTimeService.getDaysBetween(startCustom, endCustom, unit);
    }

    @RequestMapping("/weekDaysBetween")
    public String getWeekDaysBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) String startZoneId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String endZoneId,
            @RequestParam(required = false) String unit
    ) {
        if (startZoneId == null) {
            startZoneId = "UTC";
        }
        if (endZoneId == null) {
            endZoneId = "UTC";
        }
        CustomDateTime startCustom = new CustomDateTime(start, startZoneId);
        CustomDateTime endCustom = new CustomDateTime(end, endZoneId);
        return dateTimeService.getWeekDaysBetween(startCustom, endCustom, unit);
    }

    @RequestMapping("/completeWeeksBetween")
    public String getCompleteWeeksBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) String startZoneId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String endZoneId,
            @RequestParam(required = false) String unit
    ) {
        if (startZoneId == null) {
            startZoneId = "UTC";
        }
        if (endZoneId == null) {
            endZoneId = "UTC";
        }
        CustomDateTime startCustom = new CustomDateTime(start, startZoneId);
        CustomDateTime endCustom = new CustomDateTime(end, endZoneId);
        return dateTimeService.getCompleteWeeksBetween(startCustom, endCustom, unit);
    }
}
