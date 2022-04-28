package proxy3;

import java.util.List;

/**下面有个UserService类，我们需要对这个类创建一个代理。
 代码中还定义了一个接口：IMethodInfo，用来统计被代理类的一些方法信息，有个实现类：
 DefaultMethodInfo。
 通过cglib创建一个代理类，父类为UserService，并且实现IMethodInfo接口，将接口IMethodInfo所有
 方法的转发给DefaultMethodInfo处理，代理类中的其他方法，转发给其父类UserService处理。
 这个代码相当于对UserService这个类进行了增强，使其具有了IMethodInfo接口中的功能。
 * @author @Chenxc
 * @date 2022年04月27日 22:36
 */
public class DispatcherTest2 {
    public static class UserService {
        public void add() {
            System.out.println("新增用户");
        }
        public void update() {
            System.out.println("更新用户信息");
        }
    }
    //用来获取方法信息的接口
    public interface IMethodInfo {
        //获取方法数量
        int methodCount();
        //获取被代理的对象中方法名称列表
        List<String> methodNames();
    }



}
