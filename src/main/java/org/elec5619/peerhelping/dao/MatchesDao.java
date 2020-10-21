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
}
