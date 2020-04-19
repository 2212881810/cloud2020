package payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import payment.service.IPaymentService;
import qinfeng.zheng.common.entry.CommonResult;
import qinfeng.zheng.common.entry.Payment;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Integer id) {
        log.info(serverPort);
        Optional optional = paymentService.findById(id);
        CommonResult commonResult = new CommonResult(200, "查询成功", serverPort,optional);
        return commonResult;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info(serverPort);
        payment = paymentService.create(payment);
        CommonResult commonResult = new CommonResult(200, "新增成功", serverPort,payment);
        return commonResult;
    }

    /**
     * 暴露接口,用于测试openfeign调用超时
     *
     * @return
     */
    @GetMapping("/feign/timeout")
    public String testFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
