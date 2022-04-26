package beanLife.fuziBean;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author @Chenxc
 * @date 2022年04月26日 20:39
 */
public class MergedBeanDefinitionTest {
    @Test
    public void test1() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        String local = "beanLife/fuziBean/bean.xml";
        int count = reader.loadBeanDefinitions(local);
        //遍历容器中注册的所有bean信息
        for (String beanName : factory.getBeanDefinitionNames()) {
//通过bean名称获取原始的注册的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
//获取合并之后的BeanDefinition信息
            BeanDefinition mergedBeanDefinition =
                    factory.getMergedBeanDefinition(beanName);
            System.out.println(beanName);
            System.out.println("解析xml过程中注册的beanDefinition：" +
                    beanDefinition);
            System.out.println("beanDefinition中的属性信息" +
                    beanDefinition.getPropertyValues());
            System.out.println("合并之后得到的mergedBeanDefinition：" +
                    mergedBeanDefinition);
            System.out.println("mergedBeanDefinition中的属性信息" +
                    mergedBeanDefinition.getPropertyValues());
            System.out.println("---------------------------");
        }
        }
}
