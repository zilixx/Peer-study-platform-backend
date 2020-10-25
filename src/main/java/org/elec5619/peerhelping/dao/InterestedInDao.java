package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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

    // TODO: to be updated
}
