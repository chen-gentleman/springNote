package zhujiezhuru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author @Chenxc
 * @Date 2022/4/21 17:32
 */
@Component
public class IService2 {
/*    @Autowired
    private List<IService> services;
    @Autowired
    private Map<String, IService> serviceMap;*/
    @Autowired
    @Qualifier("i1")
    private List<IService> services;

    @Override
    public String toString() {
        return "IService222{" +
                "services=" + services +
                '}';
    }

    /*    @Override
    public String toString() {
        return "IService2{" +
                "services=" + services +
                ", serviceMap=" + serviceMap +
                '}';
    }*/
}
