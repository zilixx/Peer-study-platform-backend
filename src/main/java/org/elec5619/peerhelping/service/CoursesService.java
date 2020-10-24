package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.CoursesDao;
import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoursesService {
    @Autowired
    CoursesDao coursesDao;

    public CoursesEntity findByCourseId(int courseId) {
        return coursesDao.findByCourseId(courseId);
    }

    public List<CoursesEntity> readDistinctCourses() {
        return coursesDao.getAllDistinctCourses();
    }

    public List<Map<String, Object>> getTutorInfoByCourseCode(String courseCode) {
        return this.coursesDao.getTutorInfoByCourse(courseCode);
    }

    public List<Map<String, Object>> getBookedTutorList(int sid, String courseCode) {
        return this.coursesDao.getBookedTutor(sid, courseCode);
    }
}
