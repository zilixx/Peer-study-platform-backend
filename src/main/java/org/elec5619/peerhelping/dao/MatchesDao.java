package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchesDao extends CrudRepository<MatchesEntity, Long> {
    MatchesEntity findByMatchId(int matchId);

    // TODO: to be updated
    @Query(value = "select m.matchID, u.first_name, u.last_name, m.matchTime, c.courseCode " +
            "from users u, matches m, courses c " +
            "where m.tutorSid = u.sid and m.courseId = c.courseId", nativeQuery = true)
    List<Object> findByStudentId(); // Return type needs to adjust by fileds
}
