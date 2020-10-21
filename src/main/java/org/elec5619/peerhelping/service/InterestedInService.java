package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.CoursesDao;
import org.elec5619.peerhelping.dao.InterestedInDao;
import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestedInService {
    @Autowired
    InterestedInDao interestedInDao;
    @Autowired
    CoursesDao coursesDao;

    public InterestedinEntity findInterestBySid(int sid){
        return this.interestedInDao.findBySid(sid);
    }

    public InterestedinEntity findInterestByCourseId(int courseId){
        return this.interestedInDao.findByCourseId(courseId);
    }

    public List<CoursesEntity> findAllCourses() {
        return this.coursesDao.findAllCourse();
    }
}
