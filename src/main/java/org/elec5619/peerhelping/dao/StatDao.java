package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface StatDao extends CrudRepository<UsersEntity, Long> {
    @Query(value = "select count(distinct u.sid) userNum, " +
            "count(distinct c.courseId) courseNum, " +
            "count(distinct m.matchId) bookingNum, " +
            "count(distinct i.sid) tutorNum " +
            "from users u, courses c, matches m, interestedin i", nativeQuery = true)
    List<Map<String, Object>> getAllNumbers();
}
