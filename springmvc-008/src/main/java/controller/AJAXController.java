package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import bean.User;

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
    public User ajax() {
        // 非常重要，当处理器方法上添加了@ResponseBody注解,那么return返回语句返回的将不是一个“逻辑视图名称”了，而是直接将返回结果采用字符串的形式返回给浏览器
        // 底层实现原理实际上代替的就是：
        /*PrintWriter out = response.getWriter();
        out.println("This is an AJAX request");
        return "hello ajax, this is a SpringMVC test";*/

        // 当一个处理器方法上面有@ResponseBody注解，并且返回的是一个java对象，例如User，那么springmvc框架会自动将user对象转换成json字符串，并将其作为响应体返回给浏览器
        // 当然你必须在pom.xml文件中添加jackson-databind依赖，否则会报NoClassDefFoundError异常
        // 使用的消息转换器是MappingJackson2HttpMessageConverter
        User user = new User(1L, "Tom", "20");
        return user;
    }
}
