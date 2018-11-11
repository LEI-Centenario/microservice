package cn.gamesource.module.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LEIYU
 */
@RestController
@RequestMapping("/userService")
public class UserController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable(value = "id") Long id, String name) {
        return "我叫:" + name + ",我的ID是:" + id + ",我来自端口:" + port;
    }
}
