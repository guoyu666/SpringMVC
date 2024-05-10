package springmvc.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置请求体的字符集
        servletRequest.setCharacterEncoding("UTF-8");
        // 设置响应的字符集
        servletResponse.setContentType("text/html;charset=UTF-8");
        // 执行下一个资源
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
