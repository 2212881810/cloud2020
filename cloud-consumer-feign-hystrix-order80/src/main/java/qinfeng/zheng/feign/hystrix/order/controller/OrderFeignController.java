//package qinfeng.zheng.feign.hystrix.order.controller;
//
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import qinfeng.zheng.common.entry.CommonResult;
//import qinfeng.zheng.feign.hystrix.order.service.PaymentFeignService;
//
//@DefaultProperties(defaultFallback = "globalFallBackHandler")
//@RestController
//public class OrderFeignController {
//    @Autowired
//    private PaymentFeignService paymentFeignService;
//
//    @GetMapping("/ok/{id}")
//    public String ok(@PathVariable("id") Integer id) {
//        return paymentFeignService.ok(id);
//    }
//
//    @GetMapping("/timeout/{id}")
//    // 这个走timeoutHandler fallback方法
//    @HystrixCommand(fallbackMethod = "timeoutHandler",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//            })
//
//    public String timeout(@PathVariable("id") Integer id) {
//        return paymentFeignService.timeout(id);
//    }
//
//
//    @GetMapping("/timeoutGlobal/{id}")
//    @HystrixCommand  // 该标签与@DefaultProperties配合使用,走全局fallback
//    public String timeoutGlobal(@PathVariable("id") Integer id) {
//        int temp = 10 / 0;
//        return paymentFeignService.timeout(id);
//    }
//
//
//    public String timeoutHandler(Integer id) {
//        return "调用服务提供方超时或者报错,服务调用方自己进行服务降级处理....";
//    }
//
//
//    /**
//     * 全局fallback处理方法
//     */
//    public String globalFallBackHandler() {
//        return "全局fallBack,请稍后重试";
//    }
//}
