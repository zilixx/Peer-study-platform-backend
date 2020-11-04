package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.elec5619.peerhelping.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class MatchesController {
    @Autowired
    MatchesService matchesService;

    /**
     * Find the booking record with target bookingId (NOT IN USE)
     * @param bookingId target bookingId
     * @return One JSON object
     */
    @GetMapping("/{bookingId}")
    @ResponseBody
    public MatchesEntity findBooking(@PathVariable int bookingId){
        return this.matchesService.findByMatchId(bookingId);
    }

    /**
     * Get all current booking of login student
     * @param sid current login student
     * @return JSON list
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Map<String, Object>> findAllBooking(@RequestParam(value = "sid") String sid) {
        return this.matchesService.findAllBookings(Integer.parseInt(sid));
    }

    /**
     * Cancel the selected booking
     * @param matchId target booking
     * @return One JSON object with cancel status
     */
    @GetMapping("/delete")
    @ResponseBody
    public String deleteBooking(@RequestParam(value = "bookingId") String matchId){
        this.matchesService.deleteByMatchId(Integer.parseInt(matchId));

        var searchRes = this.matchesService.findByMatchId(Integer.parseInt(matchId));
        return "{\"deleteStat\": " + (searchRes == null) + "}";
    }

    /**
     * Add a new booking
     * @param courseCode the target booking course
     * @param studentId the current login student
     * @param tutorId the selected tutor
     * @return One JSON object with adding status
     */
    @GetMapping("/add/{courseCode}")
    @ResponseBody
    public String addBooking(@PathVariable(value = "courseCode") String courseCode,
                             @RequestParam("studentId") String studentId,
                             @RequestParam("tutorId") String tutorId){
        var status = this.matchesService.addBooking(Integer.parseInt(studentId), Integer.parseInt(tutorId), courseCode);
        return "{\"addStat\": " + status + "}";
    }

    @GetMapping("/tutor")
    @ResponseBody
    public List<Map<String, Object>> getStudentsOfTutor(@RequestParam("tutorId") String tutorId) {
        return this.matchesService.findAllStudentByTutorSid(Integer.parseInt(tutorId));
    }
}
