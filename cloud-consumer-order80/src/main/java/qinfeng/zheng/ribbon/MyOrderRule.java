package qinfeng.zheng.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon的轮询规则,这儿使用随机
 */
@Configuration
public class MyOrderRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
