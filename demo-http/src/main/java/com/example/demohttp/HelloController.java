package com.example.demohttp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2024/4/1 14:54
 */
@Controller
public class HelloController {


    @GetMapping("/wecom/getToken")
    public String getToken() {
        System.out.println();
        return "";
    }
}
