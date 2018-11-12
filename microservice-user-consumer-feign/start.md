本章参考文档
    https://blog.csdn.net/forezp/article/details/81040965

一.开始
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
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
    </dependencies>
    
二.改造,增加断路器Hystrix
    1.不用引入依赖,因为Feign自带Hystrix断路器,只是默认关闭,开启方式->配置文件增加 feign.hystrix.enabled: true
    2.工程改造
        @FeignClient(value="user-service-provider")-> @FeignClient(value="user-service-provider",fallback=需要处理的类.class)
        需要处理的类需要实现这个消费者接口,并注入到容器中
        比如项目中,UserServiceErrorHandle 就是容错处理的类,实现了IUserService接口
        @FeignClient(value = "user-service-provider", fallback = UserServiceErrorHandle.class)
        public interface IUserService
    3.服务链路跟踪
        参考:
          https://blog.csdn.net/forezp/article/details/81041078
          http://www.cnblogs.com/duanxz/p/7552857.html
        xml增加zipkin依赖
        配置文件增加[spring.zipkin.base-url=http://localhost:9411] 配置
    4.Hystrix断路器监控
        参考
        https://blog.csdn.net/forezp/article/details/81041113
        