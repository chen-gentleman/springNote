package event.springEvent;

import org.springframework.context.ApplicationListener;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 11:39
 */
public class SendEmailOnOrderCreateEvent implements ApplicationListener<OrderCreateEvent> {
    @Override
    public void onApplicationEvent(OrderCreateEvent orderCreateEvent) {
        System.out.println("订单："+orderCreateEvent.getOrderId() + " 创建成功，发送邮件");
    }
}
