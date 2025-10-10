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

        String visitorSubject = "🚀 Hey " + name + "! You Just Landed in My Digital Playground! ✨";

        String visitorBody = "<div style=\"font-family:'Poppins', sans-serif; text-align:center; " +
                "background: linear-gradient(135deg,#ff9a3c,#ffd200); padding:40px; border-radius:20px; " +
                "box-shadow: 0 15px 40px rgba(0,0,0,0.5); position: relative; overflow: hidden;\">" +

                // Bouncing rocket emoji
                "<span style='font-size:30px; animation: bounce 1s infinite;'>🚀</span>" +

                // Neon heading
                "<h1 style=\"font-size:32px; color:#ff6f00; text-shadow:0 0 10px #ff6f00,0 0 20px #ffd54f;\">" +
                "Hey " + name + "! Welcome to My Digital World 🌐</h1>" +

                // Funny & playful description
                "<p style=\"font-size:18px; color:#fff8e1; line-height:1.6;\">Thanks for dropping by! " +
                "You just made my day shine brighter 😎✨. Sit back, relax, and enjoy the ride 💫.<br>" +
                "Here's a joke for you while you wait:</p>" +

                // Joke
                "<p style='font-size:16px; color:#fff3b0; font-style:italic;'>Why did the developer go broke? <br>" +
                "Because he used up all his cache! 😂💻</p>" +

                // Info box
                "<p style=\"font-size:16px; color:#fff; background: rgba(255,255,255,0.1); " +
                "padding:15px; border-radius:15px; box-shadow: inset 0 0 10px rgba(255,255,255,0.2);\">" +
                "📧 Email: <strong style='color:#ffd54f;'>" + email + "</strong><br>" +
                "📱 Mobile: <strong style='color:#ff6f00;'>" + mobile + "</strong></p>" +

                // Fun closing
                "<p style='font-size:18px; color:#fff8e1;'>Stay awesome, keep smiling 😎, " +
                "and expect a reply faster than a rocket 🚀💌</p>" +

                // Signature
                "<h3 style='font-size:26px; color:#ff6f00; text-shadow:0 0 10px #ffd54f;'>Cheers,<br>Team MG 💪✨</h3>" +

                // Keyframe animations
                "<style>" +
                "@keyframes bounce {0%,100%{transform:translateY(0);}50%{transform:translateY(-10px);}}" +
                "</style>" +
                "</div>";

        // Send HTML email to visitor
        emailService.sendEmail(email, visitorSubject, visitorBody);

        // Admin notification
        String adminSubject = "👤 New Visitor Alert!";
        String adminBody = "Visitor Details:\n\nName: " + name + "\nEmail: " + email + "\nMobile: " + mobile;
        emailService.sendEmail("manojlaptop1812@gmail.com", adminSubject, adminBody);

        // Fun success message on page
        model.addAttribute("successMessage",
                "<span style='background: linear-gradient(90deg,#ff9a3c,#ffd200); color:#ff6f00; padding:12px 25px; " +
                        "border-radius:20px; box-shadow: 0 5px 15px rgba(0,0,0,0.5); font-weight:bold; font-size:16px;'>🎉 Hey " + name +
                        "! Your message has been received! Expect a reply soon 😉 - Team MG 💪✨</span>");

        return "redirect:/#connect";
    }

}
