package event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 11:26
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        UserRegisterService bean = context.getBean(UserRegisterService.class);
        bean.registerUser("陈琛琛");
    }
}
