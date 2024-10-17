package entities;

import input.AppointmentInput;

import java.sql.Timestamp;
import java.time.*;
import java.util.TimeZone;

public class Appointment {
    private long start;
    private long end;

    public Appointment(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(this.start),
                TimeZone.getDefault().toZoneId());
    }

    public LocalDateTime getEnd() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(this.end),
                TimeZone.getDefault().toZoneId());
    }
    public long getStartl() {
        return (this.start);
    }

    public long getEndl() {
        return (this.end);
    }

    public void setStart() {
        String date = AppointmentInput.insertDate();
        this.start = Timestamp.valueOf(date + " " + AppointmentInput.insertStartTime()).getTime();
        setEnd(date);
    }

    private void setEnd(String date) {
        this.end = Timestamp.valueOf(date + " " + AppointmentInput.insertEndTime()).getTime();
    }
}

