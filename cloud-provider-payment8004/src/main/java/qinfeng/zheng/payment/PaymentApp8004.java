package qinfeng.zheng.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient   // 除了eureka,不然基本都靠它去注册服务
@SpringBootApplication
public class PaymentApp8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8004.class, args);
    }

}
