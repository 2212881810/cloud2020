package qinfeng.zheng.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class PaymentApp8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApp8001.class, args);
    }
}
