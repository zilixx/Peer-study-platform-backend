package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.MatchesEntity;
import org.elec5619.peerhelping.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchesController {
    @Autowired
    MatchesService matchesService;

    @GetMapping("/booking/{bookingId}")
    @ResponseBody
    public MatchesEntity findBooking(@PathVariable int bookingId){
        return this.matchesService.findByMatchId(bookingId);
    }

    // TODO: to be updated
    @GetMapping("/booking/all")
    @ResponseBody
    public List<Object> findAllBooking() {
        return this.matchesService.findAllBookings();
    }
}
