package cn.itcast.order.client;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: UserClient
 * Package: cn.itcast.order.client
 * Description:
 *
 * @Author: 王昱晨
 * @Create: 2023/7/10 - 14:14
 * @Version: v1.0
 * @description 调用用户信息
 */
@FeignClient(value = "userservice",fallback = UserFallBack.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
