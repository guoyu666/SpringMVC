package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    // 请求映射
    // 这个方法是一个实例方法
    // 这个方法目前返回一个String字符串
    // 返回值代表一个逻辑视图名称
    // RequestMapping中代表的是请求路径
    @RequestMapping(value = "/test")
    public String hehe(){
        return "first";
    }
}
