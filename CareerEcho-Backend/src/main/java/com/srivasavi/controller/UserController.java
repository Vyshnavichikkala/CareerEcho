package com.srivasavi.controller;

import com.srivasavi.model.User;
import com.srivasavi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller 
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired private UserService service;

    @PostMapping("/register")
    @ResponseBody

    public ResponseEntity<String> register(@RequestBody User user) {
        String result = service.registerUser(user);
        if (result.equals("User registered")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result); 
        }
    }


    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        return service.validate(user.getUsername(), user.getPassword()) ? "success" : "fail";
    }

   
    @PostMapping("/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String newPassword = request.get("newPassword");

        boolean updated = service.updatePasswordByEmail(email, newPassword);
        if (updated) {
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("User not found.");
        }
    }

}
