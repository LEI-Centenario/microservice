package cn.gamesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * EnableEurekaClient 表明是Eureka客户端
 * EnableHystrix 开启断路器
 *
 * @author: LEIYU
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableDiscoveryClient
public class UserServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerApplication.class, args);
    }
}
