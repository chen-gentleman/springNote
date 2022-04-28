package beanInstantiation;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

/**这个注解可以标注在构造器上面，使用这个标注之后，创建bean的时候将使用这个构造器
 * @author @Chenxc
 * @date 2022年04月26日 21:19
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowried {

}
