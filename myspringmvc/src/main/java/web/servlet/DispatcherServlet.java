package web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 前端控制器
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
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
