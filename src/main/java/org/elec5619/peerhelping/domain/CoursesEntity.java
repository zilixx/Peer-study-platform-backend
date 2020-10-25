package org.elec5619.peerhelping.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "courses", schema = "peerhelping", catalog = "")
public class CoursesEntity {
    private int courseId;
    private String name;
    private String description;
    private String courseCode;
    private Collection<InterestedinEntity> interestedinsByCourseId;
    private Collection<MatchesEntity> matchesByCourseId;

    @Id
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "courseCode")
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesEntity that = (CoursesEntity) o;
        return courseId == that.courseId &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(courseCode, that.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, name, description, courseCode);
    }

    @OneToMany(mappedBy = "coursesByCourseId")
    public Collection<InterestedinEntity> getInterestedinsByCourseId() {
        return interestedinsByCourseId;
    }

    public void setInterestedinsByCourseId(Collection<InterestedinEntity> interestedinsByCourseId) {
        this.interestedinsByCourseId = interestedinsByCourseId;
    }

    @OneToMany(mappedBy = "coursesByCourseId")
    public Collection<MatchesEntity> getMatchesByCourseId() {
        return matchesByCourseId;
    }

    public void setMatchesByCourseId(Collection<MatchesEntity> matchesByCourseId) {
        this.matchesByCourseId = matchesByCourseId;
    }
}
