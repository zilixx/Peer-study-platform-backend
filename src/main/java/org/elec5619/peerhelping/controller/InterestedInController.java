package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.elec5619.peerhelping.service.InterestedInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/register")
public class InterestedInController {
    @Autowired
    InterestedInService interestedInService;

    private static final Logger LOGGER = LoggerFactory.getLogger(InterestedInController.class);
    private int cid;
    private String availableTime = "";
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
        this.cid = Integer.parseInt(cid);
        System.out.println(this.cid);
        return "select course " + this.cid;
    }

    @GetMapping("/selectDay")
    @ResponseBody
    public String selectDay(@RequestParam(value="day") String day) {
        this.availableTime = day;
        System.out.println(availableTime);
        return "select course " + availableTime;
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Upload failed!";
        }

        String fileName = file.getOriginalFilename();
        String filePath = new File("src\\main\\resources\\files").getAbsolutePath() + "\\";
        File dest = new File(filePath + fileName);
        var status1 = this.interestedInService.addInterestedIn(1001, this.cid);
        var status2 = this.interestedInService.addCalendar(1001, this.availableTime);
        var status = status1 && status2;
        try {
            file.transferTo(dest);
            LOGGER.info("Upload successfully!");
            return "Upload successfully!";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "{\"addStat\": " + status + "}";
    }
    // TODO: to be updated
}
