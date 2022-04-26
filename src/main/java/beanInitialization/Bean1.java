package beanInitialization;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

/**
 * EnvironmentAware：注入Environment对象
 * EmbeddedValueResolverAware：注入EmbeddedValueResolver对象
 * ResourceLoaderAware：注入ResourceLoader对象
 * ApplicationEventPublisherAware：注入ApplicationEventPublisher对象
 * MessageSourceAware：注入MessageSource对象
 * ApplicationContextAware：注入ApplicationContext对象
 *
 * 从名称上可以看出这个类以 ApplicationContext 开头的，说明这个类只能在 ApplicationContext
 * 环境中使用。
 * CommonAnnotationBeanPostProcessor调用@PostConstruct标注的方法
 * setBeanName：awareBean
 * setBeanClassLoader：sun.misc.Launcher$AppClassLoader@18b4aac2
 * setBeanFactory：
 * org.springframework.beans.factory.support.DefaultListableBeanFactory@5bb21b69:
 * defining beans [awareBean]; root of factory hierarchy
 * @Override
 * public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean,
 * String beanName)
 * throws BeansException {
 * Object result = existingBean;
 * for (BeanPostProcessor processor : getBeanPostProcessors()) {
 * Object current = processor.postProcessBeforeInitialization(result,
 * beanName);
 * if (current == null) {
 * return result;
 * }
 * result = current;
 * }
 * return result;
 * }
 * org.springframework.context.support.ApplicationContextAwareProcessor
 * org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
 * EnvironmentAware：注入Environment对象
 * EmbeddedValueResolverAware：注入EmbeddedValueResolver对象
 * ResourceLoaderAware：注入ResourceLoader对象
 * ApplicationEventPublisherAware：注入ApplicationEventPublisher对象
 * MessageSourceAware：注入MessageSource对象
 * ApplicationContextAware：注入ApplicationContext对象
 * CommonAnnotationBeanPostProcessor#postProcessBeforeInitialization 中会调用bean中所有
 * 标注@PostConstruct注解的方法
 * @author @Chenxc
 * @date 2022/4/26 22:41No such property: code for class: Script1
 * @return null
 */

public class Bean1 implements EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware,ApplicationContextAware{
    @PostConstruct
    public void postConstruct1() { //@1
        System.out.println("postConstruct1()");
    }
    @PostConstruct
    public void postConstruct2() { //@2
        System.out.println("postConstruct2()");
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:" + applicationContext);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher:" +
                applicationEventPublisher);

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("setEmbeddedValueResolver:" + stringValueResolver);

    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment:" + environment.getClass());
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("setMessageSource:" + messageSource);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader:" + resourceLoader);
    }
}
