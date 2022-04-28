package aop;

/**通过aop来实现一些需求，对work方法进行增强。
 * @Author @Chenxc
 * @Date 2022/4/28 10:35
 */
public class UserService {
    public void work(String username){
        System.out.println(username + ",正在和路人甲java一起学Spring Aop，欢迎大家一 起来！");

    }
}
