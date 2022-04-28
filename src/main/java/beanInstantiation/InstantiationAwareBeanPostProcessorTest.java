package beanInstantiation;

import beanLife.bean.Car;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 *
 * @author @Chenxc
 * @date bean初始化前阶段，会调用：{@link
 * org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessBeforeInitialization(Object, String)}
 * 21:00No such property: code for class: Script1
 * @return null
 */
public class InstantiationAwareBeanPostProcessorTest {
    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //添加一个BeanPostProcessor：InstantiationAwareBeanPostProcessor
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
                System.out.println("调用postProcessBeforeInstantiation()");
                if(beanClass == Car.class){
                    Car car = new Car();
                    car.setName("保时捷");
                    return car;
                }
                return null;
            }
        });

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Car.class).addPropertyValue("name", "奥迪").getBeanDefinition();
        factory.registerBeanDefinition("car",beanDefinition);
        System.out.println(factory.getBean("car"));

    }
}
