package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.CalendarEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CalendarDao extends CrudRepository<CalendarEntity, Long> {
    @Query(value = "SELECT * FROM calendar WHERE sid= ?1", nativeQuery = true)
    CalendarEntity findBySid(int sid);

    /**
     * Get current top calendarId
     * @return top calendarId in Integer
     */
    @Query(value = "select calendarId from calendar order by calendarId desc limit 1", nativeQuery = true)
    int findTopCalendarId();

    @Modifying
    @Transactional
    @Query(value = "insert into calendar (sid, calendarId, availableTime) " +
            "value (:sid, :calendarId, :availableTime)", nativeQuery = true)
    void addNewCalendarRow(@Param("sid") int sid,
                           @Param("calendarId") int calendarId,
                           @Param("availableTime") String availableTime);
}
