package beanInitialization;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author @Chenxc
 * @date 2022年04月26日 22:29
 */
public class InvokeAwareTest {
    @Test
    public void test1(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("awareBean", BeanDefinitionBuilder.genericBeanDefinition(AwareBean.class).getBeanDefinition());
        factory.getBean(AwareBean.class);
    }
}
