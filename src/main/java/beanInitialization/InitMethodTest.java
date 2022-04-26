package beanInitialization;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author @Chenxc
 * @date 2022年04月26日 23:16
 */
public class InitMethodTest {
    public static void main(String[] args) {
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        BeanDefinition service =
                BeanDefinitionBuilder.genericBeanDefinition(Service.class).
                        setInitMethodName("init"). //@1：指定初始化方法
                        getBeanDefinition();

        context.registerBeanDefinition("service",service);
        context.refresh();
        System.out.println(context.getBean("service"));
    }
}
