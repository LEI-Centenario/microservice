# microservice
一.简述
  这是我的 springCloud 学习项目,
  目前主要参考博客:史上最简单的SpringCloud教程 地址:https://blog.csdn.net/forezp/article/details/70148833/
  项目采用springboot2.0.5.RELEASE + springCloud Finchley.RELEASE 

二.项目结构
  microservice-parent ----------------- 项目父工程,定义springCloud版本,公共配置
  microservice-register-center -------- Eureka注册中心
  microservice-user-provider ---------- Eureka客户端,用户服务提供者
  microservice-user-consumer-ribbon  -- Eureka客户端,使用ribbon+rest的服务器消费者
  microservice-user-consumer-feign ---- Eureka客户端,使用feign的服务消费者
  pom.xml ----------------------------- 项目总pom文件,定义springboot版本,聚合模块

三.启动与部署
  1.项目导入并配置好;
  2.启动注册中心, microservice-register-center 可以在配置文件修改端口,完后访问 http://配置的hostname:配置的端口/ 可以看到配置界面;
  3.启动服务提供者 microservice-user-provider ,可以先启动成功后再修改端口启动多个,实现多服务,好做负载均衡;
  4.启动服务消费者, microservice-user-consumer-ribbon 与 microservice-user-consumer-feign 启动其中一个就可以了;
  5.访问消费者controller,按照要求传入参数,可以看到端口在不断变化,实现了负载均衡;
  
四.后续
  不停的学习不断的充实自己使自己变得更有价值,fighting!👍
