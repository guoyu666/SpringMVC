package web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * 视图接口
 */
public interface View {
    /**
     * 渲染
     */
    void render(Map<String,?> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
