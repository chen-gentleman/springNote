package event.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author @Chenxc
 * @Date 2022/4/26 11:36
 */
public class OrderCreateEvent extends ApplicationEvent {
    private Long orderId;

    public OrderCreateEvent(Object event,Long orderId){
        super(event);
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
