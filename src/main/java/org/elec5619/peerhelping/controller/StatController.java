package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatController {
    @Autowired
    StatService statService;

    @GetMapping("/stat")
    @ResponseBody
    public List<Map<String, Object>> getAllStat(){
        return statService.getAllStatNumbers();
    }
}
