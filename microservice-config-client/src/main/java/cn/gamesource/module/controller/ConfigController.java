package cn.gamesource.module.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope 配置刷新
 *
 * @author: LEIYU
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${foo}")
    String foo;

    @GetMapping("/test")
    public String test() {
        return "配置是:" + foo;
    }
}
