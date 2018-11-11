package cn.gamesource.module.user.controller;

import cn.gamesource.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IUserService userService;

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable(value = "id") Long id, String name) {
        return this.userService.getUser(id, name);
    }
}
