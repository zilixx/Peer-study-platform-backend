package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "peerhelping", catalog = "")
public class UsersEntity {
    private int sid;
    private String firstName;
    private String lastName;
    private String password;
    private String gender;
    private Collection<CalendarEntity> calendarsBySid;
    private Collection<InterestedinEntity> interestedinsBySid;
    private Collection<MatchesEntity> matchesBySid;
    private Collection<MatchesEntity> matchesBySid_0;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return sid == that.sid &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(password, that.password) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, firstName, lastName, password, gender);
    }

    @OneToMany(mappedBy = "usersBySid")
    public Collection<CalendarEntity> getCalendarsBySid() {
        return calendarsBySid;
    }

    public void setCalendarsBySid(Collection<CalendarEntity> calendarsBySid) {
        this.calendarsBySid = calendarsBySid;
    }

    @OneToMany(mappedBy = "usersBySid")
    public Collection<InterestedinEntity> getInterestedinsBySid() {
        return interestedinsBySid;
    }

    public void setInterestedinsBySid(Collection<InterestedinEntity> interestedinsBySid) {
        this.interestedinsBySid = interestedinsBySid;
    }

    @OneToMany(mappedBy = "usersByStudentSid")
    public Collection<MatchesEntity> getMatchesBySid() {
        return matchesBySid;
    }

    public void setMatchesBySid(Collection<MatchesEntity> matchesBySid) {
        this.matchesBySid = matchesBySid;
    }

    @OneToMany(mappedBy = "usersByTutorSid")
    public Collection<MatchesEntity> getMatchesBySid_0() {
        return matchesBySid_0;
    }

    public void setMatchesBySid_0(Collection<MatchesEntity> matchesBySid_0) {
        this.matchesBySid_0 = matchesBySid_0;
    }
}
