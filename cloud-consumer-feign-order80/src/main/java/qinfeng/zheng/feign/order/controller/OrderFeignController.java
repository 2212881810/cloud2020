package qinfeng.zheng.feign.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qinfeng.zheng.common.entry.CommonResult;
import qinfeng.zheng.feign.order.service.PaymentFeignService;

@RestController
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Integer id) {
        CommonResult result = paymentFeignService.findById(id);
        return result;
    }

    @GetMapping("/feign/timeout")
    public String testFeignTimeout(){
        // open-feign默认的请求超时是1s
        return paymentFeignService.testFeignTimeout();
    }
}
