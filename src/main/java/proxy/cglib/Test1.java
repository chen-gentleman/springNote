package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author @Chenxc
 * @Date 2022/4/15 14:59
 */
public class Test1 {
    public static void main(String[] args) {
        //1，创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //2，通过setSuperclass来设置父类型，即需要给哪个类创建代理类
        enhancer.setSuperclass(Service1.class);
        /*3.设置回调，需实现org.springframework.cglib.proxy.Callback接口，
        此处我们使用的是org.springframework.cglib.proxy.MethodInterceptor，也是一个接
        口，实现了Callback接口，
        当调用代理对象的任何方法的时候，都会被MethodInterceptor接口的invoke方法处理*/
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 代理对象方法拦截器
             * @param o 代理对象
             * @param method 被代理的类的方法，即Service1中的方法
             * @param objects 调用方法传递的参数
             * @param methodProxy 方法代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("调用方法"+method);
                //可以调用MethodProxy的invokeSuper调用被代理类的方法
                Object invoke = methodProxy.invokeSuper(o, objects);
                return invoke;
            }
        });

        Service1 proxy = (Service1)enhancer.create();
        proxy.m1();
        proxy.m2();
    }
}
