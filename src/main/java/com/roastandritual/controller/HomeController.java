package com.roastandritual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("shopName", "Roast & Ritual");
        return "index";
    }
    
    @GetMapping("/menu")
    public String menu(Model model) {
        return "menu";
    }
    
    @GetMapping("/shop")
    public String shop(Model model) {
        return "shop";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("address", "1245 Gibbons Lane, Portland, OR 97209");
        model.addAttribute("hours", "Mon-Fri: 7am-7pm | Sat-Sun: 8am-6pm");
        model.addAttribute("phone", "(503) 555-0124");
        model.addAttribute("email", "hello@roastandritual.com");
        return "contact";
    }
    
    @GetMapping("/cart")
    public String cart(Model model) {
        return "cart";
    }
    
    @GetMapping("/checkout")
    public String checkout(Model model) {
        return "checkout";
    }
    
    @GetMapping("/subscription")
    public String subscription(Model model) {
        return "subscription";
    }
    
    @PostMapping("/contact/submit")
    public String submitContact(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String subject,
            @RequestParam(required = false) String message,
            Model model) {
        
        System.out.println("========== CONTACT FORM SUBMISSION ==========");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("=============================================");
        
        model.addAttribute("successMessage", "Thank you for your message, " + name + "! We'll get back to you within 24 hours.");
        model.addAttribute("address", "1245 Gibbons Lane, Portland, OR 97209");
        model.addAttribute("hours", "Mon-Fri: 7am-7pm | Sat-Sun: 8am-6pm");
        model.addAttribute("phone", "(503) 555-0124");
        model.addAttribute("email", "hello@roastandritual.com");
        
        return "contact";
    }
    
    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String email, Model model) {
        System.out.println("New subscriber: " + email);
        model.addAttribute("successMessage", "Welcome to the ritual! Check your inbox.");
        return "index";
    }
    
    @PostMapping("/api/cart/add")
    @ResponseBody
    public String addToCart(@RequestParam String productName, @RequestParam double price) {
        System.out.println("Added to cart: " + productName + " - $" + price);
        return "{\"success\": true, \"message\": \"Added to cart\"}";
    }
}