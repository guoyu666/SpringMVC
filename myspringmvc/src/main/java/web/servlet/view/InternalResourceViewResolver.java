package web.servlet.view;

import web.servlet.View;
import web.servlet.ViewResolver;

import java.util.Locale;

/**
 * 内部资源的视图解析器，可以解析JSP
 */
public class InternalResourceViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        return null;
    }
}
