package cn.gamesource.module.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注解 FeignClient(需要调用的服务名字)
 * 接口每个方法配置服务
 * @author: LEIYU
 */
@FeignClient("user-service-provider")
public interface IUserService {


    /**
     * 获取用户
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/userService/getUser/{id}", method = RequestMethod.GET)
    String getUser(@PathVariable("id") Long id, @RequestParam("name") String name);
}
