package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.CalendarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDao extends CrudRepository<CalendarEntity, Long> {
    @Query(value = "SELECT * FROM calendar WHERE sid= ?1", nativeQuery = true)
    CalendarEntity findBySid(int sid);
}
