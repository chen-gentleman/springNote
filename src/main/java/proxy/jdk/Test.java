package proxy.jdk;

import proxy.jdk.Impl.IServiceImpl;
import proxy.jdk.Impl.IServiceImpl2;

import java.lang.reflect.Proxy;

/**
 * @Author @Chenxc
 * @Date 2022/4/15 14:47
 */
public class Test {
    public static void main(String[] args) {
        IServiceImpl iService = new IServiceImpl();
        IServiceImpl2 iService2 = new IServiceImpl2();
        IService proxyInstance = (IService)Proxy.newProxyInstance(iService.getClass().getClassLoader(), iService.getClass().getInterfaces(), new MyInvocationHandler(iService2));
        proxyInstance.m1();
        proxyInstance.m2();
    }
}
