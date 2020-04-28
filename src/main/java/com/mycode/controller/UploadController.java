package com.mycode.controller;

import com.mycode.model.User;
import com.mycode.util.WorkWithFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class UploadController {
    @GetMapping("/upload")
    public String openUploadForm(Model model) {
        return "upload/upload";
    }

    @PostMapping("/upload")
    public String upload(Model model, @RequestParam("file") MultipartFile file) {
        model.addAttribute("text", "Error");
        String path = "src/main/resources/data.txt";
        try {
            List<User> users = WorkWithFile.readUserFromTheFile();
            Files.write(Paths.get(path), file.getBytes());
            if (users != null) {
                for (User user : users) {
                    WorkWithFile.write(user);
                }
                model.addAttribute("text", "Complete");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/upload/result";
    }
}
