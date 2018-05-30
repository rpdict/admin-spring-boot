package sys.controller;

import sys.entity.auth.Audience;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/article/insert")
    public String index() {
        Audience test = new Audience();
        return "1";
    }

    @RequestMapping(value = "hello")
    public String say(){
        return "Hello Spring Boot!";
    }
}
