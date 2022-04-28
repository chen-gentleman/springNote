package proxy2.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 为多个接口创建代理
 * 定义了2个接口，然后通过cglib来创建一个代理类，代理类会实现这2个接口，通过
 * setCallback来对2个接口的方法进行增强
 * @Author @Chenxc
 * @Date 2022/4/27 16:14
 */
public class CglibTest1 {
    interface IService1 {
        void m1();
    }
    interface IService2 {
        void m2();
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{IService2.class,IService1.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("方法：" + method.getName());
                return null;
            }
        });
        Object proxy = enhancer.create();
        if (proxy instanceof IService1) {
            ((IService1) proxy).m1();
        }
        if (proxy instanceof IService2) {
            ((IService2) proxy).m2();
        }
//看一下代理对象的类型
        System.out.println(proxy.getClass());
//看一下代理类实现的接口
        System.out.println("创建代理类实现的接口如下：");
        for (Class<?> cs : proxy.getClass().getInterfaces()) {
            System.out.println(cs);
        }
    }
}
