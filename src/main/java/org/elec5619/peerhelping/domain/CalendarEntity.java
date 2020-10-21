package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calendar", schema = "peerhelping")
public class CalendarEntity {
    private int calendarId;
    private String availableTime;

    @Id
    @Column(name = "calendarId", nullable = false)
    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    @Basic
    @Column(name = "availableTime", nullable = false, length = 45)
    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity that = (CalendarEntity) o;
        return calendarId == that.calendarId &&
                Objects.equals(availableTime, that.availableTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendarId, availableTime);
    }
}
