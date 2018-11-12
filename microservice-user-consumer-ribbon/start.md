本章参考文档
    https://blog.csdn.net/forezp/article/details/81040946

开始:
     <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
        </dependency>
     </dependencies>


改造:增加Hystrix断路器 因为ribbon 是不自带断路器的,所以需要增加依赖;
    1.增加依赖
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
      </dependency>
    2.启动类
        增加@EnableHystrix 开启Hystrix
    3.熔断处理
         在需要处理的方法上增加 @HystrixCommand(fallbackMethod = 临时处理的方法名)
         在[临时处理的方法]里配置解决方案,参数与此方法一样;
    4.服务链路跟踪
        参考:
        https://blog.csdn.net/forezp/article/details/81041078
        http://www.cnblogs.com/duanxz/p/7552857.html
        xml增加zipkin依赖
        配置文件增加[spring.zipkin.base-url=http://localhost:9411] 配置
        
        