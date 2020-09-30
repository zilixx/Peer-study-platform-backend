package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InterestedInDao extends CrudRepository<InterestedinEntity, Long> {
    @Query(value = "SELECT * FROM interestedin WHERE courseId=?1", nativeQuery = true)
    InterestedinEntity findByCourseId(int courseId);

    @Query(value = "SELECT * FROM interestedin WHERE sid=?1", nativeQuery = true)
    InterestedinEntity findBySid(int sid);

    // TODO: to be updated
}
