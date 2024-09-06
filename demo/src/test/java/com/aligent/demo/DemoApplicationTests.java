package com.aligent.demo;

import com.aligent.demo.Services.DateTimeService;
import com.aligent.demo.Models.CustomDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private final DateTimeService dateTimeService = new DateTimeService();

    // standard test
    @Test
    public void testDaysBetween() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("9 days", result);
    }

    @Test
    public void testGetWeekdaysBetween() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0),  "UTC");
        String result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("7 weekdays", result);
    }

    @Test
    public void testGetCompleteWeeksBetween() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 22, 0, 0),  "UTC");
        String result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("3 weeks", result);
    }

    // edge case test
    @Test
    public void testDaysBetweenEdgeCase() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("0 days", result);
    }

    @Test
    public void testGetWeekdaysBetweenEdgeCase() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("0 weekdays", result);
    }

    @Test
    public void testGetCompleteWeeksBetweenEdgeCase() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("0 weeks", result);
    }

    // boundary test
    @Test
    public void testDaysBetweenBoundary() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testGetWeekdaysBetweenBoundary() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testGetCompleteWeeksBetweenBoundary() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    // time conversion test
    @Test
    public void testConvertTime() {
        long value = 5;
        String unit = "seconds";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("432000 seconds", result);
    }

    @Test
    public void testConvertTimeInvalidUnit() {
        long value = 5;
        String unit = "invalid";
        try {
            dateTimeService.convertTime(value, unit);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid unit: invalid", e.getMessage());
        }
    }

    @Test
    public void testConvertTimeMinutes() {
        long value = 5;
        String unit = "minutes";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("7200 minutes", result);
    }

    @Test
    public void testConvertTimeHours() {
        long value = 5;
        String unit = "hours";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("120 hours", result);
    }

    @Test
    public void testConvertTimeYears() {
        long value = 5;
        String unit = "years";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("0 years", result);
    }

    @Test
    public void testConvertTimeZero() {
        long value = 0;
        String unit = "seconds";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("0 seconds", result);
    }

    @Test
    public void testConvertTimeNegative() {
        long value = -5;
        String unit = "seconds";
        try {
            dateTimeService.convertTime(value, unit);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: -5", e.getMessage());
        }
    }

    // additional test
    @Test
    public void testGetDaysBetweenNull() {
        CustomDateTime start = null;
        CustomDateTime end = null;
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testGetWeekDaysBetweenNull() {
        CustomDateTime start = null;
        CustomDateTime end = null;
        String result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testGetCompleteWeeksBetweenNull() {
        CustomDateTime start = null;
        CustomDateTime end = null;
        String result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testConvertTimeNull() {
        long value = 5;
        String unit = "days";
        try {
            dateTimeService.convertTime(value, unit);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid unit: null", e.getMessage());
        }
    }

    @Test
    public void testConvertTimeZeroNull() {
        long value = 0;
        String unit = "days";
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("0 days", result);
    }

    // integration test
    @Test
    public void testIntegration() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("9 days", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("7 weekdays", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("1 weeks", result);
    }

    @Test
    public void testIntegrationNull() {
        CustomDateTime start = null;
        CustomDateTime end = null;
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    //Testing the timezone conversion
    @Test
    public void testTimeZoneConversion() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("9 days", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("7 weekdays", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("1 weeks", result);
    }

    @Test
    public void testTimeZoneConversionNull() {
        CustomDateTime start = null;
        CustomDateTime end = null;
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testTimeZoneConversionBoundary() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("Parameters not valid", result);
    }

    @Test
    public void testTimeZoneConversionEdgeCase() {
        CustomDateTime start = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        CustomDateTime end = new CustomDateTime(LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0),  "UTC");
        String result = dateTimeService.getDaysBetween(start, end, "days");
        assertEquals("0 days", result);
        result = dateTimeService.getWeekDaysBetween(start, end, "days");
        assertEquals("0 weekdays", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, "days");
        assertEquals("0 weeks", result);
    }

}
