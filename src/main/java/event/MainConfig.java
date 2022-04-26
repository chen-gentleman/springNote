package event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 11:20
 */
@Configuration
@ComponentScan
public class MainConfig {
    /**
     * 注册一个bean：事件发布者
     * @param eventListeners
     * @return
     */
    @Bean
    @Autowired(required = false)
    public EventMulticaster eventMulticaster(List<EventListener> eventListeners){
        EventMulticaster eventMulticaster = new SimpleEventMulticaster();
        if(null != eventListeners){
            eventListeners.forEach(eventMulticaster::addEventListener);
        }
        return eventMulticaster;
    }

    /**
     * 注册一个bean：用户注册服务
     *
     * @param eventMulticaster
     * @return
     */
    @Bean
    public UserRegisterService userRegisterService(EventMulticaster
                                                           eventMulticaster) { //@2
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.setEventMulticaster(eventMulticaster);
        return userRegisterService;
    }


}
