package qinfeng.zheng.feign.hystrix.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qinfeng.zheng.feign.hystrix.order.service.PaymentFeignService01;

/**
 * 使优雅的方式处理服务降级
 */
@RestController
public class OrderFeignController01 {

    @Autowired
    private PaymentFeignService01 paymentFeignService;

    @GetMapping("/ok1/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentFeignService.ok(id);
    }

    @GetMapping("/timeout1/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.timeout(id);
    }
}
