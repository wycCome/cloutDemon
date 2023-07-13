package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    @HystrixCommand(fallbackMethod = "testBreakFall")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        if (orderId <= 0) {
            log.info("不合法，服务熔断" + orderId);
            throw new RuntimeException("数据不合法");
        }
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    public Order testBreakFall(Long orderId) {
        return new Order();
    }
}
