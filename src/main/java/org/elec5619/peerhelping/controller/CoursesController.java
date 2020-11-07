package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.MatchesEntity;
import org.elec5619.peerhelping.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    /**
     * Get available tutor list for the target course
     * @param courseCode the target courseCode
     * @return JSON list
     */
    @GetMapping("/{courseCode}")
    @ResponseBody
    public List<Map<String, Object>> findCourse(@PathVariable("courseCode") String courseCode){
        return this.coursesService.getTutorInfoByCourseCode(courseCode);
    }

    /**
     * Get all available courses
     * @return JSON list
     */
    @GetMapping("/all")
    @ResponseBody
    public List<CoursesEntity> getAllCourses() {
        return this.coursesService.readDistinctCourses();
    }

    /**
     * Get all booked tutor list for current student and course
     * @param courseCode current course
     * @param sid current login student
     * @return JSON list
     */
    @GetMapping("/booked/{courseCode}")
    @ResponseBody
    public List<Map<String, Object>> getBookedTutorList(@PathVariable("courseCode") String courseCode, @RequestParam("sid") String sid) {
        return this.coursesService.getBookedTutorList(Integer.parseInt(sid), courseCode);
    }

    /**
     * Get courses that a student have booked
     * @param sid student id
     * @return JSON list
     */
    @GetMapping("student/booked")
    @ResponseBody
    public List<Map<String, Object>> getStudentBookedCourse(@RequestParam("sid") String sid) {
        return this.coursesService.getStudentBookedCourse(Integer.parseInt(sid));
    }

    /**
     * Get courses that a tutor is responsible for
     * @param tutorId tutor id
     * @return JSON list
     */
    @GetMapping("tutor/booked")
    @ResponseBody
    public List<Map<String, Object>> getTutorBookedCourse(@RequestParam("tutorId") String tutorId) {
        return this.coursesService.getTutorBookedCourse(Integer.parseInt(tutorId));
    }

}
