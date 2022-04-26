package message;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 10:05
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MainConfig2.class);
        context.refresh();
        //输出2次
        for (int i = 0; i < 2; i++) {
            System.out.println(context.getMessage("address", null, Locale.CHINA));
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
