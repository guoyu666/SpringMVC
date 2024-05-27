package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String toIndex() {
        System.out.println("IndexController.toIndex()---->处理器方法执行了！");
        return "index";
    }

    @RequestMapping("/ok")
    public String toOk(){
        System.out.println("IndexController.toOk()---->处理器方法执行了！");
        return "ok";
    }
}
