package event;

/**用户注册服务 负责实现用户注册逻辑
 * @Author @Chenxc
 * @Date 2022/4/26 11:16
 */
public class UserRegisterService {
    //事件发布者
    private EventMulticaster eventMulticaster;

    public void registerUser(String username){
        System.out.println(String.format("用户【%s】注册成功", username));
        this.eventMulticaster.multicastEvent(new UserRegisterSuccessEvent(this,username));
    }

    public EventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }
    public void setEventMulticaster(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }
}
