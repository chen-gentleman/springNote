package proxy2;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 15:58
 */
public class Service implements IService1,IService2 {
    @Override
    public void m1() {
        System.out.println("我是m1");
    }

    @Override
    public void m2() {
        System.out.println("我是m2");
    }
}
