package cn.gamesource.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 注册中心配置
 *
 * @author: LEIYU
 */
@Configuration
public class EurekaConfig {


    /**
     * @description: 创建restTemplate  LoadBalanced表示RestTemplate使用负载均衡的方式调用服务
     * @author: LEIYU
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
