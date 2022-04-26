package beanInitialization;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author @Chenxc
 * @date 2022年04月26日 22:46
 */
public class PostProcessBeforeInitializationTest {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Bean1.class);
        context.refresh();
    }
}
