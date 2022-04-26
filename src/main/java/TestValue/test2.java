package TestValue;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2022/4/24 15:18
 */
public class test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext();
        /*下面这段是关键 start*/
//模拟从db中获取配置信息
        Map<String, Object> mailInfoFromDb = DbUtil.getMailInfoFromDb();
//将其丢在MapPropertySource中（MapPropertySource类是spring提供的一个类，是PropertySource的子类）
        MapPropertySource mailPropertySource = new MapPropertySource("mail",
                mailInfoFromDb);
//将mailPropertySource丢在Environment中的PropertySource列表的第一个中，让优先级最高
        context.getEnvironment().getPropertySources().addFirst(mailPropertySource);
        /*上面这段是关键 end*/
        context.register(MainConfig2.class);
        context.refresh();
        MailConfig mailConfig = context.getBean(MailConfig.class);
        System.out.println(mailConfig);
    }
}
