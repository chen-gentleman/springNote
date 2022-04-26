package beanInstantiation;

import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.annotation.Target;

/**通过{@link
*org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor#determineCandidateConstructors(Class, String)}来确定使用哪个构造器来创建bean实例
 * @author @Chenxc
 * @date 2022年04月26日 21:32
 */
public class SmartInstantiationAwareBeanPostProcessorTest {
    @Test
    public void test2(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //创建一个SmartInstantiationAwareBeanPostProcessor,将其添加到容器中
        factory.addBeanPostProcessor(new MySmartInstantiationAwareBeanPostProcessor());
        //创建bean定义
        AbstractBeanDefinition StringDefinition = BeanDefinitionBuilder.genericBeanDefinition(String.class).addConstructorArgValue("陈杏昌").getBeanDefinition();

        AbstractBeanDefinition integerDefinition = BeanDefinitionBuilder.genericBeanDefinition(Integer.class).addConstructorArgValue(30).getBeanDefinition();

        AbstractBeanDefinition personDefinition = BeanDefinitionBuilder.genericBeanDefinition(Person.class).getBeanDefinition();

        //注册
        factory.registerBeanDefinition("name",StringDefinition);
        factory.registerBeanDefinition("age",integerDefinition);
        factory.registerBeanDefinition("person",personDefinition);
        Person bean = factory.getBean(Person.class);
        System.out.println(bean);
    }
}
