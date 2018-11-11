package cn.gamesource.module.user.service.error;

import cn.gamesource.module.user.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * 服务调用出错容错
 *
 * @author: LEIYU
 */
@Component
public class UserServiceErrorHandle implements IUserService {
    @Override
    public String getUser(Long id, String name) {
        return "哎呀,不好意思" + name + ",服务出错啦,请稍后再试-Feign";
    }
}
