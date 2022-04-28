package destroyBean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 10:02
 */
@Configurable
public class DestroyTest {
    @Bean(destroyMethod = "customDestroyMethod")
    public  ServiceA1 serviceA1(){
        return new ServiceA1();
    }

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DestroyTest.class);
        //启动容器
        System.out.println("准备启动容器");
        context.refresh();
        System.out.println("容器启动完毕");
        System.out.println("serviceA：" + context.getBean(ServiceA1.class));
//关闭容器
        System.out.println("准备关闭容器");
//调用容器的close方法，会触发bean的销毁操作
        context.close(); //@2
        System.out.println("容器关闭完毕");

    }
}
