package destroyBean;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 10:00
 */
public class ServiceA1 implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean接口中的destroy()");

    }

    public ServiceA1() {
        System.out.println("创建ServiceA实例");
    }
    @PreDestroy
    public void preDestroy1() {
        System.out.println("preDestroy1()");
    }
    @PreDestroy
    public void preDestroy2() {
        System.out.println("preDestroy2()");
    }
    //自定义的销毁方法
    public void customDestroyMethod() { //@1
        System.out.println("我是自定义的销毁方法:customDestroyMethod()");
    }

}
