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

    public InterestedinEntity findInterestByCourseId(int courseId){
        return this.interestedInDao.findByCourseId(courseId);
    }

    public List<CoursesEntity> findAllCourses() {
        return this.coursesDao.getAllDistinctCourses();
    }

    public boolean addInterestedIn(int sid, int courseId) {
        int currentLargestInterestId = this.interestedInDao.findTopInterestedId();
        this.interestedInDao.addNewInterestedIn(sid, courseId, currentLargestInterestId+1);
        return this.interestedInDao.findTopInterestedId() == currentLargestInterestId + 1;
    }

    public boolean addCalendar(int sid, String availableTime) {
        int currentLargestCalendarId = this.interestedInDao.findTopCalendarId();
        this.interestedInDao.addNewCalendarRow(sid, currentLargestCalendarId+1, availableTime);
        return this.interestedInDao.findTopCalendarId() == currentLargestCalendarId + 1;
    }
}
