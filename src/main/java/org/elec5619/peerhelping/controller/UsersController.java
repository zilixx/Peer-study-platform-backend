package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.elec5619.peerhelping.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @ResponseBody
    @GetMapping("/login")
    public UsersEntity userLogin(@RequestParam(value = "sid") String sid,
                                 @RequestParam(value = "pwd") String pwd) {
        return this.usersService.findBySidAndPassword(Integer.parseInt(sid), pwd);
    }

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }
}
