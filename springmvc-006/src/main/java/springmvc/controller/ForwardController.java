package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping("/a")
    public String toA(){
        //  这个就不是逻辑视图名称了，是以转发的方式跳转，是一个资源路径，不能随便写，以forward：开始
        return "forward:/b";
    }

    @RequestMapping("/b")
    public String toB(){
        return "forward:/a";
    }
}
