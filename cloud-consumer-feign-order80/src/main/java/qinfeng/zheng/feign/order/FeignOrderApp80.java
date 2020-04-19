package qinfeng.zheng.feign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignOrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApp80.class, args);
    }
}
