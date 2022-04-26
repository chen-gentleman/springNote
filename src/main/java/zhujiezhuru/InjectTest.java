package zhujiezhuru;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author @Chenxc
 * @Date 2022/4/21 15:13
 */
public class InjectTest {
    @Test
    public void test0(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        for(String beanName : context.getBeanDefinitionNames()){
            System.out.println(beanName+"->"+context.getBean(beanName));
        }
    }

}
