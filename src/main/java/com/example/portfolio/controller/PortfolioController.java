package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PortfolioController {

    @GetMapping("/")
    public String index(Model model) {
        // Simple sample data. Replace with DB or JSON later if you want.
        Map<String,String> profile = Map.of(
                "name", "Manoj Gavhane",
                "title", "Java Full Stack Developer | DevOps Enthusiast",
                "email", "manojkgavhane@gmail.com",
                "phone", "+91 8378863043",
                "birthday", "Sep 18, 2003",
                "location", "Pune, Maharashtra, India",
                "avatar", "/css/images/mg1.jpg" // put avatar.jpg in static/images
        );

        List<Map<String,String>> tools= List.of(
                // Programming
                Map.of("title","Java","desc","Programming Language","img","/css/images/java1.png"),
                Map.of("title","HTML","desc","Markup Language","img","/css/images/html.png"),
                Map.of("title","CSS","desc","Styling Web Pages","img","/css/images/css.png"),
                Map.of("title","JavaScript","desc","Basic Scripting","img","/css/images/js.png"),


                // Tools & IDE
                Map.of("title","Git","desc","Version Control System","img","/css/images/git.png"),
                Map.of("title","GitHub","desc","Code Repository","img","/css/images/github.png"),
                Map.of("title","Postman","desc","API Testing Tool","img","/css/images/postman.png"),
                Map.of("title","Maven","desc","Build Tool","img","/css/images/maven.png"),
                Map.of("title","JIRA","desc","Project Management (Basic)","img","/css/images/jira.png"),
                Map.of("title","VS Code","desc","IDE","img","/css/images/vscode.png"),
                Map.of("title","Eclipse","desc","IDE","img","/css/images/eclipse.png"),
                Map.of("title","STS","desc","Spring Tool Suite IDE","img","/css/images/sts.png"),
                Map.of("title","Intellij","desc","Intellij idea","img","/css/images/intellij.png"),

                // DevOps & Cloud
                Map.of("title","Linux","desc","Operating System / CLI","img","/css/images/linux.png"),
                Map.of("title","Docker","desc","Containerization","img","/css/images/docker.png"),
                Map.of("title","Jenkins","desc","CI/CD Tool","img","/css/images/jenkins.png"),
                Map.of("title","AWS EC2","desc","Cloud Deployment","img","/css/images/aws.png"),

                // Frameworks & Technologies
                Map.of("title","Spring Boot","desc","Java Framework","img","/css/images/springboot.png"),
                Map.of("title","Hibernate","desc","ORM Framework","img","/css/images/hibernate.png"),
                Map.of("title","JDBC","desc","Database Connectivity","img","/css/images/jdbc.png"),
                Map.of("title","Servlet","desc","Web Component","img","/css/images/servlet.png"),
                Map.of("title","Thymeleaf","desc","Template Engine","img","/css/images/thymeleaf.png"),
                Map.of("title","Bootstrap","desc","Front-End Framework","img","/css/images/bs.png"),

                // Databases
                Map.of("title","MySQL","desc","Relational Database","img","/css/images/mysql.png")



        );


        model.addAttribute("profile", profile);
        model.addAttribute("tools", tools);


        return "index";
    }
}
