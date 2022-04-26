package beanInstantiation;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author @Chenxc
 * @date 2022年04月26日 22:02
 */
public class InstantiationAwareBeanPostProcessoryTest1 {
    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //添加一个InstantiationAwareBeanPostProcessor阻止user1的属性赋值
        factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
                if("user1".equals(beanName)){
                    //postProcessAfterInstantiation 方法返回false的时候，后续的Bean属性赋值前处理、Bean
                    //属性赋值都会被跳过了
                    return false;
                }
                return true;
            }

            @Override
            public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
                System.out.println(pvs);
                return null;
            }
        });



        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class).addPropertyValue("name","陈杏昌").addPropertyValue("age",24).getBeanDefinition();
        System.out.println(beanDefinition);
        factory.registerBeanDefinition("user1",beanDefinition);

        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class).addPropertyValue("name","刘德华").addPropertyValue("age",50).getBeanDefinition();
        factory.registerBeanDefinition("user2",beanDefinition2);

        for(String beanName:factory.getBeanDefinitionNames()){
            System.out.println(String.format("%s->%s",beanName,factory.getBean(beanName)));
        }
    }
}
