package proxy3;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.cglib.proxy.Enhancer;

import java.util.UUID;

/**
 * @author @Chenxc
 * @date 2022年04月27日 22:30
 */
public class DispatcherTest1 {
    public static class UserModel {
        private String name;
        public UserModel() {
        }
        public UserModel(String name) {
            this.name = name;
        }
        public void say() {
            System.out.println("你好：" + name);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserModel.class);
        //创建一个Dispatcher对象
        Dispatcher dispatcher = new Dispatcher() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("调用Dispatcher.loadObject()方法");

                return new UserModel("路人甲java," +
                        UUID.randomUUID().toString());
            }
        };

        enhancer.setCallback(dispatcher);
        Object proxy = enhancer.create();
        UserModel userModel = (UserModel) proxy;
        System.out.println("第1次调用say方法");
        userModel.say();
        System.out.println("第1次调用say方法");
        userModel.say();
    }

}
