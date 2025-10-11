package com.example.portfolio.controller;

import com.example.portfolio.service.EmailService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class CVDownloadController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/downloadCV")
    public void downloadCV(@RequestParam String name,
                           @RequestParam String email,
                           @RequestParam String mobile,
                           HttpServletResponse response) throws IOException {

        // ===== Validation =====
        if (name == null || name.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                mobile == null || mobile.trim().isEmpty() ||
                !mobile.matches("\\d{10}")) {

            // Redirect back with error
            response.sendRedirect("/#cv-section?error=All fields required & mobile must be 10 digits");
            return;
        }

        // ===== Send admin notification =====
        String adminSubject = "CV Download Request";
        String adminBody = "Name: " + name + "\nEmail: " + email + "\nMobile: " + mobile;
        emailService.sendEmail("gavhaneam@gmail.com", adminSubject, adminBody);

        // ===== Serve the PDF directly =====
        InputStream pdfStream = getClass().getResourceAsStream("/static/css/files/manojcv.pdf");

        if (pdfStream != null) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"manojcv.pdf\"");

            try (OutputStream out = response.getOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = pdfStream.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                out.flush();
            } finally {
                pdfStream.close();
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "CV not found on server.");
        }
    }
}
