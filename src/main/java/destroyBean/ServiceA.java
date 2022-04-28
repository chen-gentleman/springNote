package destroyBean;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 9:49
 */
public class ServiceA {
    public ServiceA() {
        System.out.println("create " + this.getClass());
    }
}
