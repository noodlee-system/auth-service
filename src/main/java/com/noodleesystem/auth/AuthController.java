package com.noodleesystem.auth;
  
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
  
@RestController
public class AuthController {

    @CrossOrigin(origins = "http://localhost")
    @PostMapping("/auth")
    public Map<String, String> auth(@RequestBody AuthRequestBody request) { 
        String username = request.getUsername();
        HashMap<String, String> responseMap = new HashMap<>();
        
        // generate mock token 
        responseMap.put("token", "b3a5fed2-93c3-40d8-aa28-a0a0bd0391e3");
   
        return responseMap; 
    }
}
