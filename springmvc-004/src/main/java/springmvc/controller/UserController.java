package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springmvc.pojo.User;

@Controller
public class UserController {

    @RequestMapping("/")
    public String toRegister() {
        // 返回一个逻辑视图
        return "register";
    }

    // @RequestMapping(value = "/user/reg",method = RequestMethod.POST)
    /*@PostMapping(value = "/user/reg")
    public String register(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] interests = request.getParameterValues("interest");
        String intro = request.getParameter("intro");
        System.out.println(name + "," + password + "," + sex + "," + Arrays.toString(interests) + "," + intro);

        // 返回一个逻辑视图
        return "ok";
    }*/

    /*@PostMapping("/user/reg")
    public String register(
            @RequestParam(name = "username")
            String username,
            @RequestParam(name = "password")
            String password,
            @RequestParam(name = "sex")
            Integer sex,    // SpringMVC可以自动帮助我们做类型转换，从前端提交的是'0'/'1'字符串，可以自动转换成Integer类型
            @RequestParam(name = "interest")
            String[] interest,
            @RequestParam(name = "intro")
            String intro
    ) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);
        return "ok";
    }*/

    @PostMapping("/user/reg")
    public String register(User user,
                           @RequestHeader(value = "Referer", required = false, defaultValue = "") String referer,
                           @CookieValue(value = "id", required = false,defaultValue = "") String id) {
        System.out.println(user);
        System.out.println(referer);
        System.out.println("客户端提交过来的cookie，它的值是: " + id);
        return "ok";
    }
}
