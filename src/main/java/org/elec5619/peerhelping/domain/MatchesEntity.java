package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "matches", schema = "peerhelping", catalog = "")
public class MatchesEntity {
    private int matchId;
    private int studentSid;
    private int tutorSid;
    private int courseId;
    private String matchTime;
    private UsersEntity usersByStudentSid;
    private UsersEntity usersByTutorSid;
    private CoursesEntity coursesByCourseId;

    @Id
    @Column(name = "matchId")
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    @Basic
    @Column(name = "studentSid")
    public int getStudentSid() {
        return studentSid;
    }

    public void setStudentSid(int studentSid) {
        this.studentSid = studentSid;
    }

    @Basic
    @Column(name = "tutorSid")
    public int getTutorSid() {
        return tutorSid;
    }

    public void setTutorSid(int tutorSid) {
        this.tutorSid = tutorSid;
    }

    @Basic
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "matchTime")
    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchesEntity that = (MatchesEntity) o;
        return matchId == that.matchId &&
                studentSid == that.studentSid &&
                tutorSid == that.tutorSid &&
                courseId == that.courseId &&
                Objects.equals(matchTime, that.matchTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, studentSid, tutorSid, courseId, matchTime);
    }

    @ManyToOne
    @JoinColumn(name = "studentSid", referencedColumnName = "sid", nullable = false)
    public UsersEntity getUsersByStudentSid() {
        return usersByStudentSid;
    }

    public void setUsersByStudentSid(UsersEntity usersByStudentSid) {
        this.usersByStudentSid = usersByStudentSid;
    }

    @ManyToOne
    @JoinColumn(name = "tutorSid", referencedColumnName = "sid", nullable = false)
    public UsersEntity getUsersByTutorSid() {
        return usersByTutorSid;
    }

    public void setUsersByTutorSid(UsersEntity usersByTutorSid) {
        this.usersByTutorSid = usersByTutorSid;
    }

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId", nullable = false)
    public CoursesEntity getCoursesByCourseId() {
        return coursesByCourseId;
    }

    public void setCoursesByCourseId(CoursesEntity coursesByCourseId) {
        this.coursesByCourseId = coursesByCourseId;
    }
}
