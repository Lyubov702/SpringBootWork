package com.mycode.controller;

import com.mycode.model.User;
import com.mycode.util.WorkWithFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;


@Controller
public class AddUserController {
    @RequestMapping(value="/user", method=RequestMethod.GET)

    public String UserForm(Model model){
        model.addAttribute("user", new User());
        return "/add/addUser";
    }

    @RequestMapping(value="/user", method= RequestMethod.POST)
    public String userSubmit(@ModelAttribute @Valid User user, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "/add/addUser";
        }
        WorkWithFile.write(user);
        return "/add/result";
    }
}
