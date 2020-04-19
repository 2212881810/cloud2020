package qinfeng.zheng.feign.hystrix.order.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentFeignService01 {
    @Override
    public String ok(Integer id) {
        return "--------------PaymentFallBackService fallback ok----";
    }

    @Override
    public String timeout(Integer id) {
        return "--------------PaymentFallBackService fallback timeout----";
    }
}
