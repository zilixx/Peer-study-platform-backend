package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface UsersDao extends CrudRepository<UsersEntity, Long> {
    UsersEntity findBySid(int sid);

    @Modifying
    @Transactional
    void deleteBySid(int sid);

    UsersEntity findBySidAndPassword(int sid, String pwd);

    /**
     * Find the tutor's current students
     * @param tutorId the tutor sid
     * @return JSON list object
     */
    @Query(value = "select u.sid, u.first_name, u.last_name, m.matchTime, c.courseCode " +
            "from users u, matches m, courses c " +
            "where m.tutorSid=:tutorId and u.sid = m.studentSid and m.courseId = c.courseId", nativeQuery = true)
    List<Map<String, Object>> findAllStudentByTutorSid(@Param(value = "tutorId") int tutorId);
}
