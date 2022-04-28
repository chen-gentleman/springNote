package proxy2.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.LazyLoader;

/**LazyLoader是cglib用于实现懒加载的callback。当被增强bean的方法初次被调用时，会触发回调，之
 后每次再进行方法调用都是对LazyLoader第一次返回的bean调用，hibernate延迟加载有用到过这个
 * @Author @Chenxc
 * @Date 2022/4/27 16:41
 */
public class LazyLoaderTest1 {
    public static class UserModel {
        private String name;

        public UserModel() {
        }

        public UserModel(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void say() {
            System.out.println("你好：" + name);
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserModel.class);
        enhancer.setCallback(new LazyLoader() {
            @Override
            public Object loadObject() throws Exception {
                System.out.println("调用LazyLoader.loadObject()方法");
                return new UserModel("路人甲java");
            }
        });
        Object proxy = enhancer.create();
        UserModel userModel = (UserModel) proxy;
        /**
         * 当第1次调用say方法的时候，会被cglib拦截，进入lazyLoader的loadObject内部，将这个方法的返回
         * 值作为say方法的调用者，loadObject中返回了一个 路人甲Java 的UserModel，cglib内部会将
         * loadObject方法的返回值和say方法关联起来，然后缓存起来，而第2次调用say方法的时候，通过方法
         * 名去缓存中找，会直接拿到第1次返回的UserModel，所以第2次不会进入到loadObject方法中了
         */
        System.out.println("第1次调用say方法");
        userModel.say();
        System.out.println("第2次调用say方法");
        userModel.say();
        System.out.println("第3次调用say方法");
        userModel.say();
    }
}
