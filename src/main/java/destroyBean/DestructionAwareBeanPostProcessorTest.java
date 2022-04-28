package destroyBean;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 *  * 1. 调用
 *  * org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#destroyB
 *  * ean
 *  * 2. 调用org.springframework.beans.factory.config.ConfigurableBeanFactory#destroySingletons
 *  * 3. 调用ApplicationContext中的close方法
 * @Author @Chenxc
 * @Date 2022/4/27 9:48
 */
public class DestructionAwareBeanPostProcessorTest {
    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());

        factory.registerBeanDefinition("serviceA1", BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition());
        factory.registerBeanDefinition("serviceA2",
                BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition())
        ;
        factory.registerBeanDefinition("serviceA3",
                BeanDefinitionBuilder.genericBeanDefinition(ServiceA.class).getBeanDefinition())
        ;
        //触发所有单例bean初始化
        factory.preInstantiateSingletons(); //@1
        System.out.println("销毁serviceA1");
        //销毁指定的bean
        factory.destroySingleton("serviceA1");//@2
        System.out.println("触发所有单例bean的销毁");
        factory.destroySingletons();
    }


    @Test
    public void test2() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//添加自定义的DestructionAwareBeanPostProcessor
        factory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
//@1
//将CommonAnnotationBeanPostProcessor加入
        factory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor()); //@2
//向容器中注入bean
        factory.registerBeanDefinition("serviceB",
                BeanDefinitionBuilder.genericBeanDefinition(ServiceB.class).getBeanDefinition())
        ;
//触发所有单例bean初始化
        factory.preInstantiateSingletons();
        System.out.println("销毁serviceB");
//销毁指定的bean
        factory.destroySingleton("serviceB");
    }

}
