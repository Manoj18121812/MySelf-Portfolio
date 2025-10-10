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

        List<Map<String,String>> tools = List.of(
                // Programming
                Map.of("title","Java","desc","Java is a high-level, object-oriented programming language. It is widely used for building enterprise applications, backend systems, and Android apps.","img","/css/images/java1.png"),
                Map.of("title","HTML","desc","HTML is the standard markup language for creating web pages. It structures content on the web and works with CSS and JavaScript to design websites.","img","/css/images/html.png"),
                Map.of("title","CSS","desc","CSS is used to style HTML content. It controls layout, colors, fonts, and responsive design to make web pages visually appealing.","img","/css/images/css.png"),
                Map.of("title","JavaScript","desc","JavaScript is a versatile scripting language used to create interactive web pages. It can run on both client-side and server-side environments.","img","/css/images/js.png"),

                // Tools & IDE
                Map.of("title","Git","desc","Git is a distributed version control system. It helps track code changes, manage collaboration, and maintain project history efficiently.","img","/css/images/git.png"),
                Map.of("title","GitHub","desc","GitHub is a cloud-based platform for hosting Git repositories. It enables collaboration, code review, and project management through pull requests and issues.","img","/css/images/github.png"),
                Map.of("title","Postman","desc","Postman is an API testing tool used for building, testing, and documenting APIs. It simplifies backend development and integration workflows.","img","/css/images/postman.png"),
                Map.of("title","Maven","desc","Maven is a build automation tool for Java projects. It manages dependencies, project builds, and provides standard project structure.","img","/css/images/maven.png"),
                Map.of("title","JIRA","desc","JIRA is a project management and issue tracking tool. It helps teams plan, track, and manage tasks, sprints, and agile workflows.","img","/css/images/jira.png"),
                Map.of("title","VS Code","desc","Visual Studio Code is a lightweight code editor. It supports multiple languages, extensions, debugging, and version control integration.","img","/css/images/vscode.png"),
                Map.of("title","Eclipse","desc","Eclipse is a powerful IDE for Java and other languages. It provides code editing, debugging, and plugin support for enterprise development.","img","/css/images/eclipse.png"),
                Map.of("title","STS","desc","Spring Tool Suite (STS) is an IDE designed for Spring applications. It offers specialized tools, templates, and integrations for rapid Spring development.","img","/css/images/sts.png"),
                Map.of("title","Intellij","desc","IntelliJ IDEA is a comprehensive IDE for Java and Kotlin development. It provides smart coding assistance, refactoring, and integration with modern frameworks.","img","/css/images/intellij.png"),

                // DevOps & Cloud
                Map.of("title","Linux","desc","Linux is an open-source operating system widely used in servers and development environments. Its command-line interface allows automation and system management.","img","/css/images/linux.png"),
                Map.of("title","Docker","desc","Docker is a containerization platform. It allows packaging applications with all dependencies for consistent deployment across environments.","img","/css/images/docker.png"),
                Map.of("title","Jenkins","desc","Jenkins is a popular CI/CD automation tool. It facilitates building, testing, and deploying applications automatically through pipelines.","img","/css/images/jenkins.png"),
                Map.of("title","AWS EC2","desc","Amazon EC2 is a cloud computing service that provides scalable virtual servers. It is used for deploying applications, hosting websites, and managing cloud infrastructure.","img","/css/images/aws.png"),

                // Frameworks & Technologies
                Map.of("title","Spring Boot","desc","Spring Boot is a Java framework for building production-ready applications quickly. It simplifies configuration and supports microservices architecture.","img","/css/images/springboot.png"),
                Map.of("title","Hibernate","desc","Hibernate is an ORM framework for Java. It simplifies database interactions by mapping objects to tables and supports complex queries efficiently.","img","/css/images/hibernate.png"),
                Map.of("title","JDBC","desc","JDBC is a Java API for connecting and executing queries with databases. It provides standard methods for CRUD operations and transaction management.","img","/css/images/jdbc.png"),
                Map.of("title","Thymeleaf","desc","Thymeleaf is a modern server-side Java template engine. It enables creating dynamic web pages with HTML templates integrated with Spring Boot.","img","/css/images/thymeleaf.png"),
                Map.of("title","Bootstrap","desc","Bootstrap is a front-end framework for designing responsive websites. It offers prebuilt components, grid system, and utilities for faster development.","img","/css/images/bs.png"),

                // Databases
                Map.of("title","MySQL","desc","MySQL is a relational database management system. It is widely used for storing, querying, and managing structured data efficiently.","img","/css/images/mysql.png")
        );



        model.addAttribute("profile", profile);
        model.addAttribute("tools", tools);


        return "index";
    }
}
