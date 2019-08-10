package com.noodleesystem.template;
  
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
import org.springframework.web.bind.annotation.RequestParam;

import com.noodleesystem.template.model.User;
import com.noodleesystem.template.repository.UserRepository;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
  
@RestController
@RequestMapping("/api")
public class TemplateController {
    @Autowired
	private UserRepository usersRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/users")
	public List<User> getAllUsers() {
		return usersRepository.findAll();
	}

    @GetMapping("/addMessage")
    public String get(@RequestParam String message) {
        rabbitTemplate.convertAndSend("test", message);
        return "Message sent into 'test' queue!";
    }

    @GetMapping("/receiveMessage")
    public String get() {
        Object message = rabbitTemplate.receiveAndConvert("test");
        
        if (message != null) {
            return message.toString();
        } else {
            return "No message in queue 'test'!";
        }
    }
}
