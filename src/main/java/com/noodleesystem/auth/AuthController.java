package com.noodleesystem.auth;
  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  
@RestController
public class AuthController { // nazwa klasy 
    @RequestMapping("/auth")
    public String auth() { 
        return "Hello World! :)"; 
    }
}