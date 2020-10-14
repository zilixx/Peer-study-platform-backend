package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calendar", schema = "peerhelping")
public class CalendarEntity {
    private int calendarId;
    private String availableTimeStarts;
    private String availableTimeDuration;

    @Id
    @Column(name = "calendarId", nullable = false)
    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    @Basic
    @Column(name = "availableTimeStarts", nullable = false, length = 45)
    public String getAvailableTimeStarts() {
        return availableTimeStarts;
    }

    public void setAvailableTimeStarts(String availableTimeStarts) {
        this.availableTimeStarts = availableTimeStarts;
    }

    @Basic
    @Column(name = "availableTimeDuration", nullable = false, length = 45)
    public String getAvailableTimeDuration() {
        return availableTimeDuration;
    }

    public void setAvailableTimeDuration(String availableTimeDuration) {
        this.availableTimeDuration = availableTimeDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity that = (CalendarEntity) o;
        return calendarId == that.calendarId &&
                Objects.equals(availableTimeStarts, that.availableTimeStarts) &&
                Objects.equals(availableTimeDuration, that.availableTimeDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calendarId, availableTimeStarts, availableTimeDuration);
    }
}
