package sys.controller;

import sys.common.Constant;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {
    
    @RequestMapping("/article/insert")
    public Object index(HttpServletRequest request, HttpServletResponse response) {
        Object aa = request.getAttribute(Constant.CLAIMS);
        return aa;
    }

    @RequestMapping(value = "hello")
    public String say(){
        return "Hello Spring Boot!";
    }
}
