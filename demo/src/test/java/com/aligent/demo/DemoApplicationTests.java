package com.aligent.demo;

import com.aligent.demo.Services.DateTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private final DateTimeService dateTimeService = new DateTimeService();

    //standard test
    @Test
    public void testDaysBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0);
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertEquals("9 days", result);
    }

    @Test
    public void testGetWeekdaysBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0);
        String result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertEquals("7 weekdays", result);
    }

    @Test
    public void testGetCompleteWeeksBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 22, 0, 0);
        String result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertEquals("3 weeks", result);
    }

    //edge case test
    @Test
    public void testDaysBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertEquals("0 days", result);
    }

    @Test
    public void testGetWeekdaysBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertEquals("0 weekdays", result);
    }

    @Test
    public void testGetCompleteWeeksBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertEquals("0 weeks", result);
    }

    //boundary test
    @Test
    public void testDaysBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertNull(result);
    }

    @Test
    public void testGetWeekdaysBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertNull(result);
    }

    @Test
    public void testGetCompleteWeeksBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        String result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertNull(result);
    }

    //Time conversion test
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

    //additional test
    @Test
    public void testGetDaysBetweenNull() {
        LocalDateTime start = null;
        LocalDateTime end = null;
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertNull(result);
    }

    @Test
    public void testGetWeekDaysBetweenNull() {
        LocalDateTime start = null;
        LocalDateTime end = null;
        String result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertNull(result);
    }

    @Test
    public void testGetCompleteWeeksBetweenNull() {
        LocalDateTime start = null;
        LocalDateTime end = null;
        String result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertNull(result);
    }

    @Test
    public void testConvertTimeNull() {
        long value = 5;
        String unit = null;
        try {
            dateTimeService.convertTime(value, unit);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid unit: null", e.getMessage());
        }
    }

    @Test
    public void testConvertTimeZeroNull() {
        long value = 0;
        String unit = null;
        String result = dateTimeService.convertTime(value, unit);
        assertEquals("0 days", result);
    }

    //integration test
    @Test
    public void testIntegration() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0);
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertEquals("9 days", result);
        result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertEquals("7 weekdays", result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertEquals("1 weeks", result);
    }

    @Test
    public void testIntegrationNull() {
        LocalDateTime start = null;
        LocalDateTime end = null;
        String result = dateTimeService.getDaysBetween(start, end, null, null);
        assertNull(result);
        result = dateTimeService.getWeekDaysBetween(start, end, null, null);
        assertNull(result);
        result = dateTimeService.getCompleteWeeksBetween(start, end, null, null);
        assertNull(result);
    }


}
