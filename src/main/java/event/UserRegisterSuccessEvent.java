package event;

/**
 *
 * @Author @Chenxc
 * @Date 2022/4/26 10:23
 */
public class UserRegisterSuccessEvent extends AbstractEvent {
    //用户名
    private String username;


    public UserRegisterSuccessEvent(Object source,String username){
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
