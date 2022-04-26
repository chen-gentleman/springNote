package event.springEvent;

import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 11:41
 */
public class Test {
    public static void main(String[] args) {
        //创建事件广播器
        ApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        //向事件广播器注册监听器
        multicaster.addApplicationListener(new SendEmailOnOrderCreateEvent());
        //广播事件
        multicaster.multicastEvent(new OrderCreateEvent(multicaster,465461l));
    }
}
