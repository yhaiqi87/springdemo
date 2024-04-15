package com.example.demohttp;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/4/3 11:23
 */
public interface WeComService {
    public String getToken();

    public String getUser(String accessToken, String code);
}
