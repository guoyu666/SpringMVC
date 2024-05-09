package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping({"/testVal1","/testVal2"})
    public String testRequestMappingValue(){
        // 返回逻辑视图
        return "test_value";
    }

    //  这里就映射了一个RESTFul风格的URL
    @RequestMapping("/login/{username}/{password}")
    public String testRESTFulURL(@PathVariable("username") String username, @PathVariable("password") String password){
        System.out.println("用户名：" + username + ",密码：" + password);
        return "ok";
    }
}
