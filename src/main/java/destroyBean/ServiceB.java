package destroyBean;

import javax.annotation.PreDestroy;

/**
 * @Author @Chenxc
 * @Date 2022/4/27 9:56
 */
public class ServiceB {
    public ServiceB() {
        System.out.println("create " + this.getClass());
    }
    //标注了@PreDestroy注解
    //这个注解是在 CommonAnnotationBeanPostProcessor#postProcessBeforeDestruction 中
    //被处理的，所以只需要将这个加入BeanPostProcessor列表就可以了
    @PreDestroy
    public void preDestroy() { //@1
        System.out.println("preDestroy()");
    }
}
