package zhujiezhuru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author @Chenxc
 * @Date 2022/4/21 14:48
 */
@Component
public class Service2 {
    private Service1 service1;

    public Service2() {
        System.out.println(this.getClass() + "无参构造器");
    }

/*    @Autowired
    public Service2(Service1 service1) {
        this.service1 = service1;
        System.out.println(this.getClass() + "有参构造器");
    }*/

/*    @Autowired
    public void injectService1(Service1 service1) { //@1
        System.out.println(this.getClass().getName() + ".injectService1()");
        this.service1 = service1;
    }*/

    @Autowired
    public void setService1(Service1 service1) { //@1
        System.out.println(this.getClass().getName() + ".setService1方法");
        this.service1 = service1;
    }


    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
