package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.InterestedinEntity;
import org.elec5619.peerhelping.service.InterestedInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterestedInController {
    @Autowired
    InterestedInService interestedInService;

    @GetMapping("/getinterest")
    @ResponseBody
    public InterestedinEntity getInterestBySid(@RequestParam(value = "sid") String sid){
        return this.interestedInService.findInterestBySid(Integer.parseInt(sid));
    }

    // TODO: to be updated
}
