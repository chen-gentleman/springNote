package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author @Chenxc
 * @Date 2022/4/15 14:43
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object invoke = method.invoke(this.target, args);
        long endTime = System.nanoTime();
        System.out.println("方法耗时(纳秒):" + (endTime - startTime));
        return invoke;
    }
}
