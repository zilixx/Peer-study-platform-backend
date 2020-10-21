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

    @GetMapping("/{bookingId}")
    @ResponseBody
    public MatchesEntity findBooking(@PathVariable int bookingId){
        return this.matchesService.findByMatchId(bookingId);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Map<String, Object>> findAllBooking(@RequestParam(value = "sid") String sid) {
        return this.matchesService.findAllBookings(Integer.parseInt(sid));
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteBooking(@RequestParam(value = "bookingId") String matchId){
        this.matchesService.deleteByMatchId(Integer.parseInt(matchId));

        var searchRes = this.matchesService.findByMatchId(Integer.parseInt(matchId));
        if (searchRes == null) {
            return "{\"deleteStat\": true}";
        } else {
            return "{\"deleteStat\": false}";
        }
    }
}
