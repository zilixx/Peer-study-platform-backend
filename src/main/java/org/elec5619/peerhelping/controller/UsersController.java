package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.elec5619.peerhelping.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping("/login")
    public UsersEntity userLogin(@RequestParam(value = "sid") String sid,
                                 @RequestParam(value = "pwd") String pwd) {
        return this.usersService.findBySidAndPassword(Integer.parseInt(sid), pwd);
    }
}
