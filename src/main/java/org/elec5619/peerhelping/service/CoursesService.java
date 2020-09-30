package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.CoursesDao;
import org.elec5619.peerhelping.domain.CoursesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {
    @Autowired
    CoursesDao coursesDao;

    public CoursesEntity findByCourseId(int courseId) {
        return coursesDao.findByCourseId(courseId);
    }

    // TODO: to be updated
}
