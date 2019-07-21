package com.noodleesystem.auth;
  
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.noodleesystem.auth.model.User;
import com.noodleesystem.auth.model.AuthRequestBody;

import com.noodleesystem.auth.repository.UserRepository;
  
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
	private UserRepository usersRepository;

    @CrossOrigin
    @PostMapping("/auth")
    public Map<String, String> auth(@RequestBody AuthRequestBody request) { 
        String username = request.getUsername();
        HashMap<String, String> responseMap = new HashMap<>();
        
        // generate mock token 
        responseMap.put("token", "b3a5fed2-93c3-40d8-aa28-a0a0bd0391e3");
   
        return responseMap; 
    }

    @GetMapping("/test")
    public String getTestAnswer() {
        return "test answer";
    }

    @GetMapping("/employees")
	public List<User> getAllUsers() {
		return usersRepository.findAll();
	}
}
