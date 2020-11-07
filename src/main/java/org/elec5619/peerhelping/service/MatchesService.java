package org.elec5619.peerhelping.service;

import org.elec5619.peerhelping.dao.CalendarDao;
import org.elec5619.peerhelping.dao.CoursesDao;
import org.elec5619.peerhelping.dao.MatchesDao;
import org.elec5619.peerhelping.dao.UsersDao;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatchesService {
    @Autowired
    MatchesDao matchesDao;

    @Autowired
    CoursesDao coursesDao;

    @Autowired
    CalendarDao calendarDao;

    @Autowired
    UsersDao usersDao;

    public List<Map<String, Object>> findAllBookings(int sid) {
        return this.matchesDao.findByStudentId(sid);
    }

    public void deleteByMatchId(int matchId) {
        this.matchesDao.deleteByMatchId(matchId);
    }

    public MatchesEntity findByMatchId(int matchId){
        return this.matchesDao.findByMatchId(matchId);
    }

    /**
     * Add new booking record into the database
     * @param studentId target student sid
     * @param tutorId target tutor sid
     * @param courseCode courseCode of the reserved course, used for getting the courseId
     */
    public boolean addBooking(int studentId, int tutorId, String courseCode) {
        // Get the value for each field of the table matches.
        int courseId = this.coursesDao.getCoursesEntityByCourseCode(courseCode).getCourseId();
        int currentLargestMatchId = this.matchesDao.findTopMatchId();
        String matchTime = this.calendarDao.findBySid(tutorId).getAvailableTime();

        // Insert new record into the database.
        this.matchesDao.addNewBooking(currentLargestMatchId+1, studentId, tutorId, courseId, matchTime);

        // Look up the new matching record to make sure it inserts successfully
        return this.matchesDao.findTopMatchId() == currentLargestMatchId + 1;
    }

    // MODIFIED
    /**
     * Find all the students that have booked study help with target tutor
     * @param tutorId target tutor sid
     * @return JSON list object, including student sid, student full name and student`s booked courseCode
     */
    public List<Map<String, Object>> findAllStudentByTutorSid(String courseCode, int tutorId) {
        return this.usersDao.findAllStudentByTutorSid(courseCode, tutorId);
    }
}
