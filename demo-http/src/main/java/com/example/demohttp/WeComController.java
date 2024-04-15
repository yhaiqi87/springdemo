package com.example.demohttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/4/19 21:43
 */
@RestController
public class WeComController {
    @Autowired
    private WeComService weComService;

    @GetMapping("/wecom/getToken")
    public String getToken() {
        System.out.println();
        return weComService.getToken();
    }

    /**
     * 根据access token和code获取用户信息
     *
     * @param accessToken access token
     * @param code code
     * @return 用户信息
     */
    @GetMapping("/wecom/getUser")
    public String getUser(String accessToken, String code) {
        return weComService.getUser(accessToken, code);
    }

}
