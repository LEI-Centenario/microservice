package cn.gamesource.module.user.service.impl;

import cn.gamesource.module.user.service.IUserService;
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

    @Override
    public String getUser(Long id, String name) {
        return restTemplate.getForObject(SERVICE_BASE_URL + "userService/getUser/" + id + "?name=" + name, String.class);
    }
}
