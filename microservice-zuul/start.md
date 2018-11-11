本章参考文档
    https://blog.csdn.net/forezp/article/details/81041012
    
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
            <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
        </dependency>
    </dependencies>
    zuul不仅可以实现路由,还可以进行过滤,具体看filter里
    
二.改造
    本段参考资料: https://blog.csdn.net/ityouknow/article/details/79215698
    1.增加服务熔断:
        zuul网关、服务消费者启动,服务提供方没有启动,消费者通过网关访问服务提供者,会直接报错,没有进行熔断,所以我们需要在网关
        这里做熔断机制,需要进行转发的消费者服务器都需要实现 FallbackProvider 接口进行熔断处理
        具体代码  cn.gamesource.core.fallback 包下
    2.增加路由重试
        配置增加
            #是否开启重试功能
            zuul.retryable=true
            #对当前服务的重试次数
            ribbon.MaxAutoRetries=2
            #切换相同Server的次数
            ribbon.MaxAutoRetriesNextServer=0
        
    