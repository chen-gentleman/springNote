package beanInstantiation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author @Chenxc
 * @date 2022年04月26日 21:22
 */
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanClass);
        System.out.println("调用 MySmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors 方法");
        //反射获取构造方法列表
        Constructor<?>[] constructors = beanClass.getConstructors();
        if(null != constructors){
            List<Constructor<?>> collect = Arrays.stream(constructors).filter((constructor) -> {
                return constructor.isAnnotationPresent(MyAutowried.class);
            }).collect(Collectors.toList());
            Constructor[] constructors1 = collect.toArray((new Constructor[collect.size()]));
            return constructors1.length != 0 ?constructors1:null;
        }else {
            return null;
        }
    }
}
