package proxy2;

import java.lang.reflect.Proxy;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 16:03
 */
public class Test {
    @org.junit.Test
    public void test(){
        Service service = new Service();
        Object proxyObject = Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new CostTimeInvocationHandler(service));
        //判断代理对象是否是Service类型的，肯定是false咯
        System.out.println(String.format("proxyObject instanceof Service = %s",
                proxyObject instanceof Service));
//判断代理对象是否是IService1类型的，肯定是true
        System.out.println(String.format("proxyObject instanceof IService1 = %s",
                proxyObject instanceof IService1));
//判断代理对象是否是IService2类型的，肯定是true
        System.out.println(String.format("proxyObject instanceof IService2 = %s",
                proxyObject instanceof IService2));
//将代理转换为IService1类型
        IService1 service1 = (IService1) proxyObject;
//调用IService2的m1方法
        service1.m1();
//将代理转换为IService2类型
        IService2 service2 = (IService2) proxyObject;
//调用IService2的m2方法
        service2.m2();
//输出代理的类型
        System.out.println("代理对象的类型:" + proxyObject.getClass());

    }
}
