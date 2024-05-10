package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    // 当前端发送的请求路径是/user/login,并且发送的请求方式是以POST方式请求的，则可以正常映射
    // 当前端发送的请求路径不是/user/login，请求方式是POST，不会映射到这个方法上
    // 当前端发送的请求路径是/user/login，请求方式不是POST，也不会映射到这个方法上
    @RequestMapping(value = "/user/login",method = {RequestMethod.POST})
    public String userLogin(){
        System.out.println("处理登录的业务...");
        return "ok";
    }

    // 当请求路径是/testParams,并且提交的参数包括username和password才能映射成功
    @RequestMapping(value = "/testParams",params = {"username","password"})
    public String testParams(){
        return "ok";
    }

    // 只有当请求路径是/testHeaders，并且请求头当中有Referer和Host这样才能映射成功
    @RequestMapping(value = "/testHeaders",headers = {"Referer","Host"})
    public String testHeaders(){
       return "ok";
    }
}
