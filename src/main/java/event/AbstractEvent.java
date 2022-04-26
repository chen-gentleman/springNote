package event;

import org.springframework.web.context.AbstractContextLoaderInitializer;

/**事件对象
 * @Author @Chenxc
 * @Date 2022/4/26 10:28
 */
public abstract class AbstractEvent {
    //事件源
    private Object source;

    public AbstractEvent(Object source){
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
