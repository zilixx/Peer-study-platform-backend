package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.CoursesEntity;
import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.elec5619.peerhelping.service.InterestedInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/register")
public class InterestedInController {
    @Autowired
    InterestedInService interestedInService;

    @GetMapping("/all")
    @ResponseBody
    public List<CoursesEntity> getAllCourse() {
        return this.interestedInService.findAllCourses();
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,
                         @RequestParam("sid") String sid,
                         @RequestParam("time") String time,
                         @RequestParam("courseId") String courseId) throws FileNotFoundException {
        String fileName = file.getOriginalFilename();
        String filePath = new File("src\\main\\resources\\static\\upload").getAbsolutePath() + "\\";

        // Create local file if not exists
        boolean status = false;
        var localFile = new File(filePath + fileName);
        if(!localFile.exists()) {
            try {
                status = localFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Write into local file.
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Insert into database
        var iStat =  this.interestedInService.addInterestedIn(Integer.parseInt(sid), Integer.parseInt(courseId));
        var cStat = this.interestedInService.addCalendar(Integer.parseInt(sid), time);

        return "{\"fileStat\": " + status + ", \"insertStat\": " + (iStat & cStat) + "}";
    }
}
