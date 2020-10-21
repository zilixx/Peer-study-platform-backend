package org.elec5619.peerhelping.dao;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesDao extends CrudRepository<CoursesEntity, Long> {
    CoursesEntity findByCourseId(int courseId);

    @Query(value = "SELECT * FROM courses", nativeQuery = true)
    List<CoursesEntity> findAllCourse();
    // TODO: to be updated

}
