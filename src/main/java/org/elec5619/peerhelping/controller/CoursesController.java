package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    // Dynamic URI using REST standards
    @GetMapping("/courses/{courseId}")
    @ResponseBody
    public CoursesEntity findCourse(@PathVariable("courseId") String courseId){
        return this.coursesService.findByCourseId(Integer.parseInt(courseId));
    }

    //TODO: to be updated
}
