package qinfeng.zheng.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced  // 妈的. 没添加这个注解,竟然会解析地址失败,看来这个注解不禁是负载均衡,还应该起到了解析请求地址的作用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
