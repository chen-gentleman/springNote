package proxy2.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**定义了2个接口：IService1和IService2，2个接口有个实现类：Service，然后通过cglib创建了个代
 理类，实现了这2个接口，并且将Service类作为代理类的父类  带有 $$EnhancerByCGLIB$$ 字样的，在调试spring的过程中，发现有这样字样的，基本上都是cglib创
 建的代理对象。

 * @Author @Chenxc
 * @Date 2022/4/27 16:21
 */
public class CglibTest2 {
    interface IService1 {
        void m1();
    }
    interface IService2 {
        void m2();
    }
    public static class Service implements IService1, IService2 {
        @Override
        public void m1() {
            System.out.println("m1");
        }
        @Override
        public void m2() {
            System.out.println("m2");
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setInterfaces(new Class[]{IService1.class,IService2.class,});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long startime = System.nanoTime();
                Object result = methodProxy.invokeSuper(o, objects); //调用父类中的方法
                System.out.println(method + "，耗时(纳秒):" + (System.nanoTime() -
                        startime));
                return result;
            }
        });
        //创建代理对象
        Object proxy = enhancer.create();
//判断代理对象是否是Service类型的
        System.out.println("proxy instanceof Service" + (proxy instanceof
                Service));
        if (proxy instanceof Service) {
            Service service = (Service) proxy;
            service.m1();
            service.m2();
        }
        //看一下代理对象的类型
        System.out.println(proxy.getClass());
        //输出代理对象的父类
        System.out.println("代理类的父类：" + proxy.getClass().getSuperclass());
        //看一下代理类实现的接口
        System.out.println("创建代理类实现的接口如下：");
        for (Class<?> cs : proxy.getClass().getInterfaces()) {
            System.out.println(cs);
        }




    }


}
