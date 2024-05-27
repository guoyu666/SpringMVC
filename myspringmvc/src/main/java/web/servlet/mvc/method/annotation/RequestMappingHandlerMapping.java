package web.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import web.servlet.HandlerExecutionChain;
import web.servlet.HandlerMapping;

/**
 * 处理器映射器：专门为@RequestMapping注解服务器处理器映射
 */
public class RequestMappingHandlerMapping implements HandlerMapping {
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        return null;
    }
}
