package qinfeng.zheng.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZkOrderApp80 {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApp80.class, args);
    }
}
