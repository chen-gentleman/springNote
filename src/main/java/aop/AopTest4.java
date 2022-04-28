package aop;

import org.junit.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @Author @Chenxc
 * @Date 2022/4/28 15:23
 */
public class AopTest4 {

    @Test
    public void test1(){
        ProxyFactory proxyFactory=new ProxyFactory(new FundsService());
        //ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                String username = (String)(objects[0]);
                if(!"路人".equals(username)){
                    throw new RuntimeException(username + "非法访问!");
                }

            }
        });
        //proxyFactory.setTarget(new FundsService());
        FundsService proxy = (FundsService)proxyFactory.getProxy();
        proxy.recharge("路人",100);
        proxy.recharge("张学友", 100);
    }

    @Test
    public void test2(){
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(new FundsService());
        ////添加一个异常通知，发现异常之后发送消息给开发者尽快修复bug
        proxyFactory.addAdvice(new SendMsgThrowsAdvice());
        //通过代理工厂创建代理
        FundsService proxy = (FundsService)proxyFactory.getProxy();
        //调用代理的方法
        proxy.cashOut("张三",2000);

    }


}
