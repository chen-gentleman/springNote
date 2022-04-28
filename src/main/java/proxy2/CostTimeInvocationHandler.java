package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 15:59
 */
public class CostTimeInvocationHandler implements InvocationHandler {
    private Object target;

    public CostTimeInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object invoke = method.invoke(this.target, args);
        long endTime = System.nanoTime();
        System.out.println(method + "方法耗时:"+(endTime - startTime));
        return invoke;
    }
}
