package springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"x","y"}) // 标注x,y都是存放到session域中的，而不是request域
public class SessionScopeTestController {

    @RequestMapping("/testSessionServletAPI")
    public String testServletAPI(HttpSession session){
        // 向会话域中存储数据
        session.setAttribute("testSessionScope","在SpringMVC当中原生的Servlet API完成session域数据共享!!");
        // 返回逻辑视图名称
        return "ok";
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(ModelMap modelMap){
        // 将数据存入到session域当中
        modelMap.addAttribute("x","我是郭雨!!");
        modelMap.addAttribute("y","我是LuoYiYan");
        // 返回逻辑视图名称
        return "ok";
    }
}
