package beanInitialization;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author @Chenxc
 * @date 2022年04月26日 22:27
 */
public class AwareBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName：" + name);
    }
}
