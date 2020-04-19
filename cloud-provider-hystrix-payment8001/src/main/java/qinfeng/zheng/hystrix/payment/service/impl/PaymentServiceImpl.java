package qinfeng.zheng.hystrix.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import qinfeng.zheng.hystrix.payment.service.IPaymentService;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements IPaymentService {
    /**
     * 正常方法,返回ok
     *
     * @param id
     * @return
     */
    @Override
    public String ok(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " is ok, id is " + id;

    }


    /**
     * 模拟出错方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            // 如果超时时间小于等于3秒,走正常的方法,否则走降级方法timeoutHandler
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String timeout(Integer id) {
//         超时异常
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 运行异常
//        int temp = 10 / id;
        return "线程池:" + Thread.currentThread().getName() + " is timeout, id is " + id;

    }

    public String timeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "系统繁忙或运行报错,服务提供方进行降级处理...";
    }
    //-=================以下是服务熔断=================

    @HystrixCommand(fallbackMethod = "paymentCircurtBreak_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  // 请求次当我
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuirtBreak(Integer id) {

        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }
        String serialNo = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号:" + serialNo;
    }

    public String paymentCircurtBreak_fallback(Integer id) {
        return "id不能为负数,请稍后重试";
    }


}
