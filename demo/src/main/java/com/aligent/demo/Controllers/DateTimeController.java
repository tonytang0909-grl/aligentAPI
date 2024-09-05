package com.aligent.demo.Controllers;

import com.aligent.demo.Models.CustomDateTime;
import com.aligent.demo.Services.DateTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(DateTimeController.class);

    @RequestMapping("/daysBetween")
    public String getDaysBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam(required = false) String startZoneId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam(required = false) String endZoneId,
            @RequestParam(required = false) String unit
    ) {
        // Log the request
        logger.debug("Received request for daysBetween with start={}, startZoneId={}, end={}, endZoneId={}, unit={}",
                start, startZoneId, end, endZoneId, unit);
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
        // Log the request
        logger.debug("Received request for weekDaysBetween with start={}, startZoneId={}, end={}, endZoneId={}, unit={}",
                start, startZoneId, end, endZoneId, unit);
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
        // Log the request
        logger.debug("Received request for completeWeeksBetween with start={}, startZoneId={}, end={}, endZoneId={}, unit={}",
                start, startZoneId, end, endZoneId, unit);
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
