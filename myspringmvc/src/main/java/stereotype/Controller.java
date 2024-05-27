package stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标注控制器，被标注的控制器纳入IoC容器管理
 */
@Target(ElementType.TYPE) // 表示该注解子能标注类
@Retention(RetentionPolicy.RUNTIME) // 表示该注解可以被反射机制读取
public @interface Controller {
}
