package com.aligent.demo;

import com.aligent.demo.Services.DateTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private final DateTimeService dateTimeService = new DateTimeService();

    //standard test
    @Test
    public void testDaysBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0);
        long result = dateTimeService.getDaysBetween(start, end, null);
        assertEquals(9, result);
    }

    @Test
    public void testGetWeekdaysBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 10, 0, 0);
        long result = dateTimeService.getWeekDaysBetween(start, end, null);
        assertEquals(7, result);
    }

    @Test
    public void testGetCompleteWeeksBetween() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 22, 0, 0);
        long result = dateTimeService.getCompleteWeeksBetween(start, end, null);
        assertEquals(3, result);
    }

    //edge case test
    @Test
    public void testDaysBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getDaysBetween(start, end, null);
        assertEquals(0, result);
    }

    @Test
    public void testGetWeekdaysBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getWeekDaysBetween(start, end, null);
        assertEquals(0, result);
    }

    @Test
    public void testGetCompleteWeeksBetweenEdgeCase() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getCompleteWeeksBetween(start, end, null);
        assertEquals(0, result);
    }

    //boundary test
    @Test
    public void testDaysBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getDaysBetween(start, end, null);
        assertEquals(-1, result);
    }

    @Test
    public void testGetWeekdaysBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getWeekDaysBetween(start, end, null);
        assertEquals(-1, result);
    }

    @Test
    public void testGetCompleteWeeksBetweenBoundary() {
        LocalDateTime start = LocalDateTime.of(2024, Month.JANUARY, 2, 0, 0);
        LocalDateTime end = LocalDateTime.of(2024, Month.JANUARY, 1, 0, 0);
        long result = dateTimeService.getCompleteWeeksBetween(start, end, null);
        assertEquals(-1, result);
    }



}
