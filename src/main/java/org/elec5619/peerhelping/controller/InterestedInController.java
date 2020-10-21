package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.elec5619.peerhelping.service.InterestedInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register")
public class InterestedInController {
    @Autowired
    InterestedInService interestedInService;

    @GetMapping("/getinterest")
    @ResponseBody
    public InterestedinEntity getInterestBySid(@RequestParam(value = "sid") String sid){
        return this.interestedInService.findInterestBySid(Integer.parseInt(sid));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<CoursesEntity> getAllCourse() {
        return this.interestedInService.findAllCourses();
    }

    @GetMapping("/select")
    @ResponseBody
    public String selectCourse(@RequestParam(value="courseId") String cid) {
        System.out.println(cid);
        return "select course " + cid;
    }
    // TODO: to be updated
}
