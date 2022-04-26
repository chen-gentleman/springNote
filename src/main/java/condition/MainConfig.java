package condition;

import condition.impl.IServiceImpl1;
import condition.impl.IServiceImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Author @Chenxc
 * @Date 2022/4/21 12:39
 */
@Configuration
//@Conditional(MyCondition.class)
public class MainConfig {
    @Bean
    public String name(){
        System.out.println("name33333");
        return "name333";
    }

    @Conditional(OnMissingBeanCondition.class)
    @Bean
    public IService iService1(){
        return new IServiceImpl1();
    }
   // @Conditional(OnMissingBeanCondition.class)
    @Bean
    public IService iService2(){
        return new IServiceImpl2();
    }

}
