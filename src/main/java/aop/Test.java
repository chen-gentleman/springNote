package aop;

import bean.User;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @Author @Chenxc
 * @Date 2022/4/28 10:43
 */
public class Test {
    //通过aop来实现一些需求，对work方法进行增强
    @org.junit.Test
    public void test1(){
        //定义目标对象
        UserService target = new UserService();
        //创建pointcut,用来拦截userService中的work方法
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> aClass) {
                        return UserService.class.isAssignableFrom(aClass);
                    }
                };
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "work".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };
        //创建通知，此处需要在方法之前执行操作，所以需要用到MethodBeforeAdvice类型的通知
        MethodBeforeAdvice advice = new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("你好:" + objects[0]);
            }
        };

        //创建Advisor，将pointcut和advice组装起来
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
        //通过spring提供的代理创建工厂来创建代理
        ProxyFactory proxyFactory = new ProxyFactory();
        //为工厂指定目标对象
        proxyFactory.setTarget(target);
        //调用addAdvisor方法，为目标添加增强的功能，即添加Advisor，可以为目标添加很多个Advisor
        proxyFactory.addAdvisor(advisor);
        //通过工厂提供的方法来生成代理对象
        UserService userServiceProxy = (UserService) proxyFactory.getProxy();
        userServiceProxy.work("路人");
    }


    //需求：统计一下work方法的耗时，将耗时输出
    @org.junit.Test
    public void test2(){
        UserService target = new UserService();
        //定义切入点
        Pointcut pointcut = new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return (clazz)-> UserService.class.isAssignableFrom(clazz);
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return "work".equals(method.getName());
                    }

                    @Override
                    public boolean isRuntime() {
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };

        //定义通知，需要拦截方法的执行，所以需要用到MethodInterceptor类型的通知
        MethodInterceptor advice = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("准备调用"+methodInvocation.getMethod());
                long startTime = System.nanoTime();
                Object result = methodInvocation.proceed();
                long endTime = System.nanoTime();
                System.out.println("耗时(纳秒):" + (endTime - startTime));
                return result;
            }
        };
        //
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
        //
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);
        UserService userServiceProxy = (UserService)proxyFactory.getProxy();
        userServiceProxy.work("陈杏昌");
    }

}
