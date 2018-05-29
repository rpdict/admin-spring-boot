package hello.controller;

import hello.entity.auth.Audience;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        Audience test = new Audience();
        return "1"+test.getBase64Secret();
    }

    @RequestMapping(value = "hello")
    public String say(){
        return "Hello Spring Boot!";
    }
}
