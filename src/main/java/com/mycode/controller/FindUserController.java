package com.mycode.controller;

import com.mycode.model.User;
import com.mycode.util.WorkWithFile;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.GregorianCalendar;

@Controller
public class FindUserController {

    @RequestMapping(value = "/find", method = RequestMethod.GET)

    public String FindUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/findUser/find";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findUser(@ModelAttribute User user, Model model, @RequestHeader(value = "User-Agent") String agentUser) {

        user = WorkWithFile.findPerson(user.getFirstName(), user.getLastName());
        if (user != null) {

            UserAgent agent = UserAgent.parseUserAgentString(agentUser);
            String browserInfo = agent.getOperatingSystem().getName()+ " "
                    + agent.getBrowser().getName() + " "
                    + agent.getBrowserVersion();

            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("middleName", user.getMiddleName());
            model.addAttribute("age", user.getAge());
            model.addAttribute("salary", user.getSalary());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("placeOfWork", user.getPlaceOfWork());
            model.addAttribute("browserInfo", browserInfo);
            model.addAttribute("time", new GregorianCalendar().getTime());

            return "/findUser/result";
        }

        return "/findUser/notFoundUser";
    }
}

