package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "interestedin", schema = "peerhelping", catalog = "")
public class InterestedinEntity {
    private int sid;
    private int interestId;
    private int courseId;

    @Basic
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Id
    @Column(name = "interestId")
    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    @Basic
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestedinEntity that = (InterestedinEntity) o;
        return sid == that.sid &&
                interestId == that.interestId &&
                courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, interestId, courseId);
    }
}
