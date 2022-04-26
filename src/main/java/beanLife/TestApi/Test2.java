package beanLife.TestApi;

import beanLife.bean.Car;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**组装一个有属性的bean
 * @Author @Chenxc
 * @Date 2022/4/22 12:14
 */
public class Test2 {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Car.class.getName())
                .addPropertyValue("name","大众").setLazyInit(true);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        System.out.println(beanDefinition);

        //创建bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //调用registerBeanDefinition向容器中注册bean
        beanFactory.registerBeanDefinition("MyCar",beanDefinition);
        Car bean = beanFactory.getBean("MyCar", Car.class);
        System.out.println(bean);
    }
}
