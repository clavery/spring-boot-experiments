package hello.controllers;

import hello.CustomerRepository;
import hello.Greeting;
import hello.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message, Principal currentUser) throws Exception {
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageExceptionHandler
    @SendTo(value="/topic/greetings")
    public Greeting handleException(Exception exception) {
        return new Greeting("Error: " + exception.getMessage());
    }
}