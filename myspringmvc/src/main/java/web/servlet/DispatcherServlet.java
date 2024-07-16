package web.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.constant.Const;

import java.io.IOException;

/**
 * 前端控制器
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        // 找到springmvc.xml配置文件，读取配置信息

        /*<init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>*/

        // 根据以上的配置找springmvc.xml配置文件，读取配置信息
        // 获取ServletConfig对象（Servlet配置信息对象，该对象由web容器自动创建，并且将其传递给init方法，我们在这里调用以下方法可以获取该对象）
        ServletConfig servletConfig = this.getServletConfig();
        String contextConfigLocation = servletConfig.getInitParameter(Const.CONTEXT_CONFIG_LOCATION);
        System.out.println("SpringMvc配置文件路径解析完成：" + contextConfigLocation);


        // 初始化Spring容器
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    /**
     * DispatcherServlet前端控制器最核心的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDispatch(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // 处理用户的请求

    }
}
