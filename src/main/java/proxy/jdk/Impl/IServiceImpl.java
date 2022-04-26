package proxy.jdk.Impl;

import proxy.jdk.IService;

/**
 * @Author @Chenxc
 * @Date 2022/4/15 14:47
 */
public class IServiceImpl implements IService {
    @Override
    public void m1() {
        System.out.println("m1执行");
    }

    @Override
    public void m2() {
        System.out.println("m2执行");
    }
}
