package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "calendar", schema = "peerhelping", catalog = "")
public class CalendarEntity {
    private int sid;
    private int calendarId;
    private String availableTime;

    @Basic
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Id
    @Column(name = "calendarId")
    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    @Basic
    @Column(name = "availableTime")
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
        return sid == that.sid &&
                calendarId == that.calendarId &&
                Objects.equals(availableTime, that.availableTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, calendarId, availableTime);
    }
}
