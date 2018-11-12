本章参考文档
    https://blog.csdn.net/forezp/article/details/81041028


http请求地址和资源文件映射如下:
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
eg:
http://localhost:8888/foo/dev/master
or
eg:
http://localhost:8888/foo/dev

注意:
    1.客户端的spring.application.name配置config-client是和Git服务器上面的文件名相对应的，
      如果你的客户端是其他名字就报错找不到参数。作者的Git上面是有这个config-client-dev的配
      置文件的所以是config-client;
    2.客户端加载到的配置文件的配置项会覆盖本项目已有配置，比如客户端你自己配置的端口是8881，
      但是如果读取到config-clent-deiv这个配置文件中也有配置端口为8882，那么此时客户端访问的地址应该是8882

改造:
    1.高可用配置中心
        [https://blog.csdn.net/forezp/article/details/81041045]
    2.消息总线 动态修改配置
        [https://blog.csdn.net/forezp/article/details/70148833/]
        修改配置后,发送[POST]请求到 config-client [http://(服务地址)/actuator/bus-refresh]
        刷新配置.另外,[/actuator/bus-refresh]接口可以指定服务，即使用[destination]参数，比如 
        [/actuator/bus-refresh?destination=customers:**],即刷新服务名为[customers]的所有服务.