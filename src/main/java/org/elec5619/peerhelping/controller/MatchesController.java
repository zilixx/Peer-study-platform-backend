package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.elec5619.peerhelping.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MatchesController {
    @Autowired
    MatchesService matchesService;

    @GetMapping("/booking/{bookingId}")
    @ResponseBody
    public MatchesEntity findBooking(@PathVariable int bookingId){
        return this.matchesService.findByMatchId(bookingId);
    }

    @GetMapping("/booking")
    @ResponseBody
    public List<Map<String, Object>> findAllBooking(@RequestParam(value = "sid") String sid) {
        return this.matchesService.findAllBookings(Integer.parseInt(sid));
    }

    @GetMapping("/booking/delete")
    @ResponseBody
    public void deleteBooking(@RequestParam(value = "bookingId") String matchId){
        this.matchesService.deleteByMatchId(Integer.parseInt(matchId));
        // TODO: no response for this request
    }
}
