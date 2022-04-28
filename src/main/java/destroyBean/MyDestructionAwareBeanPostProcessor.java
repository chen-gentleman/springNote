package destroyBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**自定义一个DestructionAwareBeanPostProcessor
 * @Author @Chenxc
 * @Date 2022/4/27 9:47
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object o, String s) throws BeansException {
        System.out.println("准备销毁bean：" + s);
    }
}
