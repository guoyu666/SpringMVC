package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestBodyController {
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    /*
    关于 @RequestBody 的使用：
    1.该注解只能使用在处理器方法的形参上
    2.这个注解的作用是直接将请求体传题给java程序，在java程序中可以直接使用一个String类型的变量接收请求体的内容
    3.底层使用的是消息转换器是：FormHttpMessageConverter
     */

    /*
    关于 @RequestBody注解的重要用法：如果前端请求体中有json数据，则可以使用@RequestBody注解将json数据直接映射到java对象中，并直接注入到处理器方法的参数中。
    注意：同样需要jackson-databind依赖
     */
    public String save(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "ok";
    }

}
