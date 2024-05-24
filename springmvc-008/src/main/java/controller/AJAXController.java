package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AJAXController {
   /* @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("This is an AJAX request");
        return null;
    }*/

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    @ResponseBody
    public String ajax() {
        // 非常重要，当处理器方法上添加了@ResponseBody注解，则返回值将直接作为响应体返回，而不是视图名
        return "hello ajax, this is a SpringMVC test";
    }
}
