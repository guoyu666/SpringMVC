package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/first")
    public String first(){
        // 处理业务逻辑
        System.out.println("业务逻辑正在处理中....");
        // 返回一个逻辑视图名称
        return "first";
    }
}
