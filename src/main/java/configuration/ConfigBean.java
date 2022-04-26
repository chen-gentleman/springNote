package configuration;

import bean.User;
import bean.User2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author @Chenxc
 * @Date 2022/4/18 14:42
 */
@Configuration
@ComponentScan
public class ConfigBean {
    @Bean
    public User user(){
        return new User();
    }

    @Bean
    public User2 user2(){
        return new User2();
    }
}
