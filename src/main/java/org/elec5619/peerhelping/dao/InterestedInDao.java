package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InterestedInDao extends CrudRepository<InterestedinEntity, Long> {
    @Query(value = "SELECT * FROM interestedin WHERE courseId=?1", nativeQuery = true)
    InterestedinEntity findByCourseId(int courseId);

    /**
     * Find the tutor's courseId by its sid.
     * @param sid tutor sid
     * @return an InterestedinEntity object
     */
    @Query(value = "SELECT courseId FROM interestedin WHERE sid=?1", nativeQuery = true)
    InterestedinEntity findCourseIdByTutorSid(int sid);

    @Modifying
    @Transactional
    @Query(value = "insert into interestedin (sid, courseId, interestId) " +
            "value (:sid, :courseId, :interestId)", nativeQuery = true)
    void addNewInterestedIn(@Param("sid") int sid,
                            @Param("courseId") int courseId,
                            @Param("interestId") int interestId);

    @Modifying
    @Transactional
    @Query(value = "insert into calendar (sid, calendarId, availableTime) " +
            "value (:sid, :calendarId, :availableTime)", nativeQuery = true)
    void addNewCalendarRow(@Param("sid") int sid,
                            @Param("calendarId") int calendarId,
                            @Param("availableTime") String availableTime);

    @Query(value = "select interestId from interestedin order by interestId desc limit 1", nativeQuery = true)
    int findTopInterestedId();

    @Query(value = "select calendarId from calendar order by calendarId desc limit 1", nativeQuery = true)
    int findTopCalendarId();
}
