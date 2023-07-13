package cn.itcast.order.client;

import cn.itcast.order.pojo.User;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserFallBack
 * Package: cn.itcast.order.client
 * Description:
 *
 * @Author: 王昱晨
 * @Create: 2023/7/11 - 8:55
 * @Version: v1.0
 */
@Component
public class UserFallBack implements UserClient{
    @Override
    public User findById(Long id) {
        return new User(1L,"zs","ls");
    }
}
