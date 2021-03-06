package qinfeng.zheng.eureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka7001App {

    public static void main(String[] args) {
        SpringApplication.run(Eureka7001App.class, args);
        System.out.println("eureka注册中心启动成功");
    }
}
