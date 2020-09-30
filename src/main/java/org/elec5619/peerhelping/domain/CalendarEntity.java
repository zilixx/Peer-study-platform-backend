package org.elec5619.peerhelping.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "calendar", schema = "peerhelping", catalog = "")
public class CalendarEntity {
    private String availableTimeStarts;
    private String availableTimeDuration;

    @Basic
    @Column(name = "availableTimeStarts", nullable = false, length = 45)
    public String getavailableTimeStarts() {
        return availableTimeStarts;
    }

    public void setavailableTimeStarts(String availableTimeStarts) {
        this.availableTimeStarts = availableTimeStarts;
    }

    @Basic
    @Column(name = "availableTimeDuration", nullable = false, length = 45)
    public String getavailableTimeDuration() {
        return availableTimeDuration;
    }

    public void setavailableTimeDuration(String availableTimeDuration) {
        this.availableTimeDuration = availableTimeDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarEntity that = (CalendarEntity) o;
        return Objects.equals(availableTimeStarts, that.availableTimeStarts) &&
                Objects.equals(availableTimeDuration, that.availableTimeDuration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableTimeStarts, availableTimeDuration);
    }
}
