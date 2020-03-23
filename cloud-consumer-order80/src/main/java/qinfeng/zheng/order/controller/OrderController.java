package qinfeng.zheng.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import qinfeng.zheng.common.entry.CommonResult;
import qinfeng.zheng.common.entry.Payment;

@Slf4j
@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://127.0.0.1:8001";
//    使用集群的地址
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/findById/" + id, CommonResult.class);
    }
}
