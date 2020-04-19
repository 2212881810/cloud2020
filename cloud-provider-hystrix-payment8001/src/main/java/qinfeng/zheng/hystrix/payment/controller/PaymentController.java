package qinfeng.zheng.hystrix.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qinfeng.zheng.hystrix.payment.service.IPaymentService;

@RestController
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String ok = paymentService.ok(id);
        return ok + " " + serverPort;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        String timeout = paymentService.timeout(id);
        return timeout + " " + serverPort;
    }

    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuirtBreak(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuirtBreak(id);
    }
}
