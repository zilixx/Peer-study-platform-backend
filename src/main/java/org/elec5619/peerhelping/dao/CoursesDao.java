package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoursesDao extends CrudRepository<CoursesEntity, Long> {
    CoursesEntity findByCourseId(int courseId);

    // TODO: to be updated
}
