package zhujiezhuru;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author @Chenxc
 * @Date 2022/4/21 17:32
 */
@Component
@Qualifier("i1")
public class IServiceImpl1 implements IService {
}
