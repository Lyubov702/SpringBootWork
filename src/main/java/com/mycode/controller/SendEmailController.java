package com.mycode.controller;

import com.mycode.model.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

    @Controller
    public class SendEmailController {

        @GetMapping("/send")
        public String openSendEmail(Model model) {
            model.addAttribute("sender", new Sender());
            return "/send/sendEmail";
        }

        @PostMapping("/send")
        public String sendEmail(Model model, @ModelAttribute Sender sender) {
            if (Sender.sendMessage(sender)) {
                model.addAttribute("text", "has been send!");
            } else {
                model.addAttribute("text", "wasn't sent");
            }
            return "/send/result";
        }
    }

