import bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author @Chenxc
 * @Date 2022/4/14 16:14
 */
public class ApplicationTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        User user1 = context.getBean("user", User.class);
        System.out.println(user.userAndAddress());
        System.out.println(user1.userAndAddress());
    }
}
