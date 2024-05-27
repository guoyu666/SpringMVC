package web.servlet;

import java.util.List;

/**
 * 处理器执行链
 */
public class HandlerExecutionChain {
    /**
     * 处理器方法：实际上底层对象是HandlerMethod对象
     */
    private Object handler;
    /**
     * 本次请求的执行的拦截器
     */
    private List<HandlerInterceptor> interceptors;

    /**
     * 当前拦截器执行到哪个拦截器了，当前拦截器的下标
     */
    private int interceptorIndex = -1;

    public HandlerExecutionChain() {
    }

    public HandlerExecutionChain(Object handler, List<HandlerInterceptor> interceptors, int interceptorIndex) {
        this.handler = handler;
        this.interceptors = interceptors;
        this.interceptorIndex = interceptorIndex;
    }

    public Object getHandler() {
        return handler;
    }

    public void setHandler(Object handler) {
        this.handler = handler;
    }

    public List<HandlerInterceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<HandlerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public int getInterceptorIndex() {
        return interceptorIndex;
    }

    public void setInterceptorIndex(int interceptorIndex) {
        this.interceptorIndex = interceptorIndex;
    }
}
