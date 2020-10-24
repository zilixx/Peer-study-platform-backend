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

    @GetMapping("/{courseCode}")
    @ResponseBody
    public List<Map<String, Object>> findCourse(@PathVariable("courseCode") String courseCode){
        return this.coursesService.getTutorInfoByCourseCode(courseCode);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<CoursesEntity> getAllCourses() {
        return this.coursesService.readDistinctCourses();
    }

    @GetMapping("/booked/{courseCode}")
    @ResponseBody
    public List<Map<String, Object>> getBookedTutorList(@PathVariable("courseCode") String courseCode, @RequestParam("sid") String sid) {
        return this.coursesService.getBookedTutorList(Integer.parseInt(sid), courseCode); // TODO: not fully tested
    }

}
