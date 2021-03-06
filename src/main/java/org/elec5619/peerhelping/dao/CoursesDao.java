package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CoursesDao extends CrudRepository<CoursesEntity, Long> {
    /**
     * Get the courseId for input courseCode
     * @param courseCode courseCode in String
     * @return a CoursesEntity object
     */
    CoursesEntity getCoursesEntityByCourseCode(String courseCode);

    /**
     * Get all distinct courses
     * @return JSON list
     */
    @Query(value = "select distinct * from courses", nativeQuery = true)
    List<CoursesEntity> getAllDistinctCourses();

    /**
     * Get tutor sid, full name and available time by courseCode
     * @param courseCode the target courseCode
     * @return JSON list object
     */
    @Query(value = "select u.sid, u.first_name, u.last_name, cal.availableTime " +
            "from users u, courses c, calendar cal, interestedin i " +
            "where c.courseCode = :courseCode and u.sid = cal.sid and u.sid = i.sid and c.courseId = i.courseId",
            nativeQuery = true)
    List<Map<String, Object>> getTutorInfoByCourse(@Param(value = "courseCode") String courseCode);

    // MODIFIED
    /**
     * Get tutors that already have bookings in target course and target student
     * @param sid current student sid
     * @param courseCode current courseCode
     * @return JSON list object
     */
    @Query(value = "select m.tutorSid, m.matchTime, u.first_name, u.last_name, c.name " +
            "from matches m, courses c, users u " +
            "where c.courseCode = :courseCode and m.studentSid = :sid and c.courseId = m.courseId and m.tutorSid = u.sid", nativeQuery = true)
    List<Map<String, Object>> getBookedTutor(@Param("sid") int sid, @Param("courseCode") String courseCode);

    @Query(value = "select distinct c.courseId, c.name, c.description, c.courseCode " +
            "from matches m, courses c " +
            "where m.studentSid = :sid and m.courseId=c.courseId",nativeQuery = true)
    List<Map<String, Object>> findStudentBookedCourse(@Param("sid") int sid);

    @Query(value = "select distinct c.courseId, c.name, c.description, c.courseCode " +
            "from matches m, courses c " +
            "where m.tutorSid = :tutorId and m.courseId=c.courseId", nativeQuery = true)
    List<Map<String, Object>> findTutorBookedCourse(@Param("tutorId") int tutorId);
}
