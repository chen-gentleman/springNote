package beanLife.TestXML;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 16:09
 */
public class Test1 {
    public static void main(String[] args) {
        //定义一个spring容器，这个容器默认实现了BeanDefinitionRegistry，所以本身就是一个bean注册器
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //定义一个xml的BeanDefinition读取器，需要传递一个BeanDefinitionRegistry（bean注册器）对象
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        //指定bean xml配置文件的位置
        String local = "beanLife/TestXML/beans.xml";
        //通过XmlBeanDefinitionReader加载bean xml文件，然后将解析产生的BeanDefinition注册到容器容器中
        int countBean = xmlBeanDefinitionReader.loadBeanDefinitions(local);
        System.out.println((String.format("共注册了 %s 个bean",countBean)));
        //打印出注册的bean的配置信息
        for(String beanName:factory.getBeanDefinitionNames()){
            //通过名称从容器中获取对应的BeanDefinition信息
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
//获取BeanDefinition具体使用的是哪个类
            String beanDefinitionClassName = beanDefinition.getClass().getName();
//通过名称获取bean对象
            Object bean = factory.getBean(beanName);
//打印输出
            System.out.println(beanName + ":");
            System.out.println(" beanDefinitionClassName：" +
                    beanDefinitionClassName);
            System.out.println(" beanDefinition：" + beanDefinition);
            System.out.println(" bean：" + bean);
        }

    }
}
