本章参考文档
    https://blog.csdn.net/forezp/article/details/81041028


http请求地址和资源文件映射如下:
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
eg:
http://localhost:8888/config-client/dev/master
or
eg:
http://localhost:8888/config-client/dev


改造:
    1.高可用配置中心
        https://blog.csdn.net/forezp/article/details/81041045