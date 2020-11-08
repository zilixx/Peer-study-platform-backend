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
            Cookie username = new Cookie("username", user.getFirstName().strip());
            Cookie isLogin = new Cookie("isLogin", "true");
            response.addCookie(id);
            response.addCookie(username);
            response.addCookie(isLogin);
            return new ModelAndView(new RedirectView("http://localhost:8080"));
        } else {
            session.setAttribute("errMessage", "login fail, please check your username and password");
            session.setMaxInactiveInterval(5);
            return new ModelAndView(new RedirectView("/"));
        }
    }

    @PostMapping("doRegister")
    public ModelAndView doRegister(
            @RequestParam("re_sid") String sid,
            @RequestParam("gender") String gender,
            @RequestParam("re_password") String password,
            @RequestParam("first_name") String firstname,
            @RequestParam("last_name") String lastname,
            HttpSession session
    ) {
        UsersEntity user = new UsersEntity();
        System.out.println(gender);
        if (usersService.findBySid(Integer.parseInt(sid)) != null) {
            session.setAttribute("errMessage", "register fail, since user already exist");
            session.setMaxInactiveInterval(5);
        } else {
            gender = (gender.equals("secret"))?null:gender;
            user.setSid(Integer.parseInt(sid));
            user.setPassword(password);
            user.setGender(gender);
            user.setFirstName(firstname);
            user.setLastName(lastname);

            // save user
            usersService.save(user);
            session.setAttribute("successMessage", "register success, you can login with your account");
            session.setMaxInactiveInterval(5);
        }
        return new ModelAndView(new RedirectView("/"));
    }
}
