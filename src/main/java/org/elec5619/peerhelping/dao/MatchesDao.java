package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

public interface MatchesDao extends CrudRepository<MatchesEntity, Long> {
    /**
     * Find a booking with target booking ID
     * @param matchId The unique booking ID
     * @return A JSON object
     */
    MatchesEntity findByMatchId(int matchId);

    /**
     * Find bookings with target student ID
     * @param sid Student SID
     * @return JSON List object
     * */
    @Query(value = "select m.matchId, u.first_name, u.last_name, m.matchTime, c.courseCode " +
            "from users u, matches m, courses c " +
            "where m.studentSid=:sid and m.tutorSid = u.sid and m.courseId = c.courseId", nativeQuery = true)
    List<Map<String, Object>> findByStudentId(@Param(value = "sid") int sid);

    /**
     * Remove a booking with target student ID
     * @param matchId The unique booking ID
     * */
    @Modifying
    @Transactional
    void deleteByMatchId(int matchId);

    /**
     * Insert a new booking record into the database
     * @param matchId new matchId
     * @param studentSid current login student sid
     * @param tutorSid the tutor sid that current user selects
     * @param courseId the courseId
     * @param matchTime the reserved time in String
     */
    @Modifying
    @Transactional
    @Query(value = "insert into matches (matchId, studentSid, tutorSid, courseId, matchTime) " +
            "value (:matchId, :studentId, :tutorId, :courseId, :matchTime)", nativeQuery = true)
    void addNewBooking(@Param("matchId") int matchId,
                       @Param("studentId") int studentSid,
                       @Param("tutorId") int tutorSid,
                       @Param("courseId") int courseId,
                       @Param("matchTime") String matchTime);

    /**
     * Find and return the largest mathId in current database
     * @return the largest matchId in Integer
     */
    @Query(value = "select matchId from matches order by matchId desc limit 1", nativeQuery = true)
    int findTopMatchId();
}
