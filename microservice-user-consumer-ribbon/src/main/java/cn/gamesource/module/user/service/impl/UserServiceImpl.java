package cn.gamesource.module.user.service.impl;

import cn.gamesource.module.user.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: LEIYU
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * 服务提供者访问基地址,使用服务提供者应用名称访问,因为restTemplate使用了负载均衡访问,会按照应用名称进行选择注册的服务来调用;
     */
    private static final String SERVICE_BASE_URL = "http://user-service-provider/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注解 HystrixCommand 断路器 fallbackMethod=需要紧急处理的方法名;
     *
     * @param id
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "errorHandle")
    @Override
    public String getUser(Long id, String name) {
        return restTemplate.getForObject(SERVICE_BASE_URL + "userService/getUser/" + id + "?name=" + name, String.class);
    }

    /**
     * @description: 处理服务不可用时的方法;
     * @author: LEIYU
     */
    public String errorHandle(Long id, String name) {
        return "哎呀,不好意思" + name + ",服务出错啦,请稍后再试";
    }
}
