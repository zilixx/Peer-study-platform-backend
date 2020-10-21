package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.UsersEntity;
import org.elec5619.peerhelping.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @RequestMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("doLogin")
    public ModelAndView doLogin(
            @RequestParam("sid") String sid,
            @RequestParam("password") String password,
            HttpServletResponse response,
            HttpSession session
    ) {
        UsersEntity user = usersService
                .findBySidAndPassword(Integer.parseInt(sid), password);

        if (user != null) {
            Cookie id = new Cookie("sid", sid);
            Cookie username = new Cookie("username", user.getFirstName());
            response.addCookie(id);
            response.addCookie(username);
            return new ModelAndView(new RedirectView("http://localhost:8080"));
        } else {
            // if user does not exist, then redirect to login page and show message
            session.setAttribute("errMessage", "user does not exist");
            // set session time
            session.setMaxInactiveInterval(5);
            return new ModelAndView(new RedirectView("/"));
        }
    }

    @ResponseBody
    @GetMapping("doRegister")
    public String doRegister(
            @RequestParam("re_sid") String sid,
            @RequestParam("re_email") String email,
            @RequestParam("re_password") String password,
            @RequestParam("re_username") String username
    ) {
        UsersEntity user = new UsersEntity();
        if (usersService.findBySid(Integer.parseInt(sid)) != null) {
            // TODO: return duplicate user message
        } else {
//            user.setSid();
//            user.setPassword();
//            user.setGender();
//            user.setFirstName();
//            user.setLastName();

            // save user
            usersService.save(user);

            // TODO: return success message
        }
        return "main";
    }
}
