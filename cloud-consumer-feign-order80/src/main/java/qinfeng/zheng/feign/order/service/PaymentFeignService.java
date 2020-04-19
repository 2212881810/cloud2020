package qinfeng.zheng.feign.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import qinfeng.zheng.common.entry.CommonResult;

/**
 * @FeignClient + 接口 : 实现微服务的调用
 * <p>
 * 调用 CLOUD-PAYMENT-SERVICE 服务的 /findById/{id} 接口
 */


@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 其实就是调用Payment服务中,controller中方法
     * <p>
     * 注意:
     * 1.@PathVariable("id") 中的id必须指明, 否则报错
     * 2. GetMapping地址必须是访问CLOUD-PAYMENT-SERVICE服务findById接口的全路径(但是不要指定端口),否则报404
     */
    @GetMapping("/payment/findById/{id}")
    CommonResult findById(@PathVariable("id") Integer id);

    @GetMapping("/payment/feign/timeout")
    String testFeignTimeout();
}
