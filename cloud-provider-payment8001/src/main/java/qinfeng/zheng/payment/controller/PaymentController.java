package qinfeng.zheng.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import qinfeng.zheng.common.entry.CommonResult;
import qinfeng.zheng.common.entry.Payment;
import qinfeng.zheng.payment.service.IPaymentService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable Integer id) {
        log.info(serverPort);
        Optional optional = paymentService.findById(id);
        CommonResult commonResult = new CommonResult(200, "查询成功", serverPort, optional);
        return commonResult;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info(serverPort);
        payment = paymentService.create(payment);
        CommonResult commonResult = new CommonResult(200, "新增成功", serverPort, payment);
        return commonResult;
    }


    @GetMapping("/discovery")
    public Object discovery() {
//        查询所有的服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:{}", service);
        }

//        查询某个服务下面的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {

            log.info("InstanceId: {} , host:{} , port:{}, uri:{}", instance.getInstanceId(), instance.getHost(), instance.getPort(), instance.getUri());
        }
        return discoveryClient;
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
