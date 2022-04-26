package beanInitialization;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author @Chenxc
 * @date 2022年04月26日 23:16
 */
public class Service implements InitializingBean {
    public void init(){
        System.out.println("调用init()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用afterPropertiesSet()");

    }
}
