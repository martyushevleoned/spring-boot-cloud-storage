package com.example.cloudstorage.controller;

import com.example.cloudstorage.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

    @Autowired
    private FileManagerService fileManagerService;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("files", fileManagerService.getAllFiles());
        return "root";
    }

    @PostMapping("/")
    public String addFile(@RequestParam("file") MultipartFile file){

        fileManagerService.saveFile(file);

        return "redirect:/";
    }

}
