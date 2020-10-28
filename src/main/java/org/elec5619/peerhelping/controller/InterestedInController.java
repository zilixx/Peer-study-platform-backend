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

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

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

    @GetMapping("/selectDay")
    @ResponseBody
    public String selectDay(@RequestParam(value="day") String day) {
        System.out.println(day);
        return "select course " + day;
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = new File("src\\main\\resources\\files").getAbsolutePath() + "\\";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }
    // TODO: to be updated
}
