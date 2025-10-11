package com.example.portfolio.controller;

import com.example.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String mobile,
                            Model model) {

        // ===== Validation: Check Not Null or Empty =====
        if (name == null || name.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                mobile == null || mobile.trim().isEmpty()) {

            model.addAttribute("errorMessage",
                    "<span style='background: #ff4d4d; color:#fff; padding:12px 25px; " +
                            "border-radius:20px; font-weight:bold; font-size:16px;'>⚠️ All fields are required! " +
                            "Please fill in Name, Email, and Mobile.</span>");
            return "redirect:/#connect";
        }


        // ===== 1. Email to Visitor =====
        String visitorSubject = "🚀 Hey " + name + "! You Just Landed in My Digital Playground! ✨";

        String visitorBody = "<div style=\"font-family:'Poppins', sans-serif; text-align:center; " +
                "background: linear-gradient(135deg,#ff9a3c,#ffd200); padding:40px; border-radius:20px; " +
                "box-shadow: 0 15px 40px rgba(0,0,0,0.5); position: relative; overflow: hidden;\">" +

                "<span style='font-size:30px; animation: bounce 1s infinite;'>🚀</span>" +
                "<h1 style=\"font-size:32px; color:#ff6f00; text-shadow:0 0 10px #ff6f00,0 0 20px #ffd54f;\">" +
                "Hey " + name + "! Welcome to My Digital World 🌐</h1>" +
                "<p style=\"font-size:18px; color:#fff8e1; line-height:1.6;\">Thanks for dropping by! " +
                "You just made my day shine brighter 😎✨. Sit back, relax, and enjoy the ride 💫.<br>" +
                "Here's a joke for you while you wait:</p>" +
                "<p style='font-size:16px; color:#fff3b0; font-style:italic;'>Why did the developer go broke? <br>" +
                "Because he used up all his cache! 😂💻</p>" +
                "<p style=\"font-size:16px; color:#fff; background: rgba(255,255,255,0.1); " +
                "padding:15px; border-radius:15px; box-shadow: inset 0 0 10px rgba(255,255,255,0.2);\">" +
                "📧 Email: <strong style='color:#ffd54f;'>" + email + "</strong><br>" +
                "📱 Mobile: <strong style='color:#ff6f00;'>" + mobile + "</strong></p>" +
                "<p style='font-size:18px; color:#fff8e1;'>Stay awesome, keep smiling 😎, " +
                "and expect a reply faster than a rocket 🚀💌</p>" +
                "<h3 style='font-size:26px; color:#ff6f00; text-shadow:0 0 10px #ffd54f;'>Cheers,<br>Team MG 💪✨</h3>" +
                "<style>@keyframes bounce {0%,100%{transform:translateY(0);}50%{transform:translateY(-10px);}}</style>" +
                "</div>";

        // Send email to visitor
        emailService.sendEmail(email, visitorSubject, visitorBody);

        // ===== 2. Admin Notification =====
        String adminSubject = "👤 New Visitor Alert!";

// HTML body with updated colors
        String adminBody = "<div style=\"font-family:'Poppins', sans-serif; padding:30px; " +
                "background: #1f1f1f; color:#ffffff; border-radius:15px; box-shadow: 0 5px 20px rgba(0,0,0,0.5);\">" +
                "<h2 style='color:#ff6f00;'>👤 New Visitor Alert!</h2>" +
                "<p><strong style='color:#ffd54f;'>Name:</strong> <span style='color:#ffffff;'>" + name + "</span></p>" +
                "<p><strong style='color:#ffd54f;'>Email:</strong> <span style='color:#ffffff;'>" + email + "</span></p>" +
                "<p><strong style='color:#ffd54f;'>Mobile:</strong> <span style='color:#ffffff;'>" + mobile + "</span></p>" +
                "<p style='color:#ff9a3c;'>Sent directly to gavhaneam@gmail.com 🚀</p>" +
                "</div>";

// Send HTML email to admin
        emailService.sendEmail("gavhaneam@gmail.com", adminSubject, adminBody);


        // ===== 3. Success Message on Page =====
        model.addAttribute("successMessage",
                "<span style='background: linear-gradient(90deg,#ff9a3c,#ffd200); color:#ff6f00; padding:12px 25px; " +
                        "border-radius:20px; box-shadow: 0 5px 15px rgba(0,0,0,0.5); font-weight:bold; font-size:16px;'>🎉 Hey " + name +
                        "! Your message has been received! Expect a reply soon 😉 - Team MG 💪✨</span>");

        return "redirect:/#connect";
    }
}
