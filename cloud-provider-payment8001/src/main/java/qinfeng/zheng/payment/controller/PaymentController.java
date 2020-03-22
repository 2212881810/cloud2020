package qinfeng.zheng.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qinfeng.zheng.common.entry.CommonResult;
import qinfeng.zheng.common.entry.Payment;
import qinfeng.zheng.payment.service.IPaymentService;

import java.util.Optional;

@RestController
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Integer id) {
        Optional optional = paymentService.findById(id);
        CommonResult commonResult = new CommonResult(200, "查询成功", optional);
        return commonResult;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        payment = paymentService.create(payment);
        CommonResult commonResult = new CommonResult(200, "新增成功", payment);
        return commonResult;
    }
}
