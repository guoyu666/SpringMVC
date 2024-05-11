package springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RequestScopeTestController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        // 将共享的数据存储到request域当中
        request.setAttribute("testRequestScope", "在SpringMVC当中使用原生的Servlet API完成request数据共享!!");

        // 跳转视图，在视图页面将request域中的数据取出来，这样就完成了:Controller和View在同一个请求当中两个组件之间数据的共享
        // 这个跳转，默认情况下是：转发的方式（转发forward是一次请求）
        // 这个返回的是一个逻辑视图名称，经过视图解析器解析，变成物理视图名称。/WEB-INF/templates/ok.html
        return "ok";
    }

    @RequestMapping("/testModel")
    public String testMode(Model model){
        // 向request域中绑定数据
        model.addAttribute("testRequestScope","在SpringMVC当中使用Model接口完成request数据共享!!");
        // 转发
        return "ok";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        // 向request域中绑定数据
        map.put("testRequestScope","在SpringMVC当中使用Map接口完成request数据共享!!");
        // 转发
        return "ok";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建“模型与视图对象”
        ModelAndView modelAndView = new ModelAndView();
        // 绑定数据
        modelAndView.addObject("testRequestScope","在SpringMVC当中使用ModelAndView类完成request数据共享!!");
        // 给“模型视图对象”绑定视图（绑定逻辑视图名称）
        modelAndView.setViewName("ok");
        // 返回
        return modelAndView;
    }
}
