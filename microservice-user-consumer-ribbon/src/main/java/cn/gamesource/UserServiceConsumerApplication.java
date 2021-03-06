package cn.gamesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * EnableEurekaClient 表明是Eureka客户端
 * EnableHystrix 开启断路器
 * EnableHystrixDashboard 开启断路器监控面板
 *
 * @author: LEIYU
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
//这里不需要这个注解,因为有了EnableHystrix注解
//@EnableCircuitBreaker
public class UserServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerApplication.class, args);
    }
}
