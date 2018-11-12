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
    5.断路器监控
        参考: https://blog.csdn.net/forezp/article/details/81041113
        1.引入jar包,启动类添加注解 [@EnableHystrixDashboard]
        2.访问:[http://localhost:7001/actuator/hystrix.stream] 查看数据,在访问之前先调用接口获取数据
          访问:[localhost:7001/hystrix] 查看监控界面,
        3.监控方式:
            默认的集群监控：通过URL:http://turbine-hostname:port/turbine.stream开启，实现对默认集群的监控。
            指定的集群监控：通过URL:http://turbine-hostname:port/turbine.stream?cluster=[clusterName]开启，实现对clusterName集群的监控。
            单体应用的监控：通过URL:http://hystrix-app:port/hystrix.stream开启，实现对具体某个服务实例的监控。
          Delay：控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，可以通过配置该属性来降低客户端的网络和CPU消耗。
          Title: 标题,随便取一个;
          比如我要监控:[http://localhost:7001/actuator/hystrix.stream ]
          Delay:2000,Title:userConsumer
        4.监控界面参数说明:
            顶部接口下面百分数:最近10s的错误比例
            中间红色部分,Host与Cluster:请求频率
            Circuit:断路器状态
            90th,99th,99.5th:百分位延迟统计
            图形部分:
              1.实心圆:
                1、通过颜色的变化代表了实例的健康程度，健康程度从绿色、黄色、橙色、红色递减。
                2、通过大小表示请求流量发生变化，流量越大该实心圆就越大。所以可以在大量的实例中快速发现故障实例和高压实例。
              2.曲线:
                用来记录2分钟内流浪的相对变化，可以通过它来观察流量的上升和下降趋势。
          [注意：当使用Hystrix Board来监控Spring Cloud Zuul构建的API网关时，Thread Pool信息会一直处于Loading状态。这是由于Zuul默认会使用信号量来实现隔离，只有通过Hystrix配置把隔离机制改成为线程池的方式才能够得以展示。]
        
        
        