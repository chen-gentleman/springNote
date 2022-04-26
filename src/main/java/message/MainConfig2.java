package message;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 10:03
 */
@Configuration
public class MainConfig2 {
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("message");
        //设置缓存时间1000毫秒
        messageSource.setCacheMillis(0);
        return messageSource;
    }
}
