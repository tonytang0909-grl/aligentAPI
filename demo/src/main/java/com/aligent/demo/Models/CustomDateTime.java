package com.aligent.demo.Models;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomDateTime {
    private final LocalDateTime dateTime;
    private final String zoneId;

    public CustomDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.zoneId = ZoneId.systemDefault().toString();
    }
    public CustomDateTime(LocalDateTime dateTime, String zoneId) {
        this.dateTime = dateTime;
        this.zoneId = zoneId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getZoneId() {
        return zoneId;
    }

    public ZonedDateTime toZonedDateTime() {
        return dateTime.atZone(ZoneId.of(zoneId));
    }
}
