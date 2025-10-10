package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @GetMapping("/resume")
    public String resumePage(Model model) {
        Map<String, String> profile = new HashMap<>();
        profile.put("name", "Manoj Gavhane");
        profile.put("title", "Full Stack Developer | DevOps Enthusiast");
        profile.put("email", "manojkgavhane@gmail.com");
        profile.put("phone", "+91 8378863043");
        profile.put("birthday", "Jan 1, 1990");
        profile.put("location", "Pune, India");
        profile.put("avatar", "/images/mg1.jpg"); // make sure image is in static/images/

        model.addAttribute("profile", profile);
        return "resume";
    }

    @GetMapping("/portfolio")
    public String portfolioPage(Model model) {
        // Create a list of projects
        List<Map<String, String>> projects = new ArrayList<>();

        Map<String, String> project1 = new HashMap<>();
        project1.put("name", "Student Result Portal");
        project1.put("description", "A full-stack web app to manage student results using Spring Boot, Thymeleaf, and MySQL.");
        project1.put("link", "https://github.com/Manoj18121812/Student-Result-Portal"); // your project link
        project1.put("image", "/images/project1.png"); // add project image in static/images/

        Map<String, String> project2 = new HashMap<>();
        project2.put("name", "Online Job Portal");
        project2.put("description", "An online job portal built with Spring Boot and Thymeleaf supporting multiple roles.");
        project2.put("link", "https://github.com/Manoj18121812/Job-Portal"); // your project link
        project2.put("image", "/images/project2.png"); // add project image in static/images/

        projects.add(project1);
        projects.add(project2);

        model.addAttribute("projects", projects);
        return "portfolio"; // maps to portfolio.html
    }
}
