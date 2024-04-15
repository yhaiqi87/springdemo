package com.example.demohttp;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/4/3 11:23
 */
@Slf4j
@Service
public class WeComServiceImpl implements WeComService{
    private static final String URL_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    private static final String URL_USER_ID = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
    //
    private static final String host = "10.170.5.20";
    private static final int port = 5840;
    //
    private static final String corpid = "ww3d2df28238caec81";
    private static final String corpsecret = "1QQ82OgduOm1kP7slkPOk02YjfrLerUObhdln1t1XHM";

    /**
     * 企微获取ACCESS_TOKEN。getToken 示例返回结果
     * {
     * "errcode": 0,
     * "errmsg": "ok",
     * "access_token": "bol8D82bLYFlf9YNEv4EPAFoP0PdQXRl0rS-y3uT2pzpogKnwtWP_RVlIiY0FIkHmZvOr3NDIuaPftHDbhqhQC5vxsCjzD2PwoQLoDDAkF9cYCXd80nwOo6avejS4vOYzHRxgLiJgI4xOhd1xBN032X1QGxrYfxTlAVDrF2KB485ce4ImeAr10s1TVDeV5WGJZouK7E0qucP1F2Ek_GZ_g",
     * "expires_in": 7200
     * }
     *
     * @return
     */
    @Override
    public String getToken() {
        Map<String, Object> tokenParam = new HashMap<>();
        tokenParam.put("corpid", corpid);
        tokenParam.put("corpsecret", corpsecret);
        if (log.isInfoEnabled())
            log.info("getToken,地址：{},代理信息：{}:{},参数:{}", URL_TOKEN, host, port, JSONUtil.toJsonStr(tokenParam));
        String tokenJsonStr = HttpRequest.get(URL_TOKEN)
                .setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)))
                .form(tokenParam)
                .timeout(10 * 1000)
                .execute().body();
        if (log.isInfoEnabled())
            log.info("getToken,结果:{}", tokenJsonStr);
        return tokenJsonStr;
    }

    /**
     * 企微公共接口查询userid信息，示例返回
     * {
     * "errcode": 0,
     * "errmsg": "ok",
     * "userid":"USERID",
     * "user_ticket": "USER_TICKET"
     * }
     *
     * @param accessToken
     * @param code
     * @return
     */
    @Override
    public String getUser(String accessToken, String code) {
        Map<String, Object> userInfoParam = new HashMap<>();
        userInfoParam.put("access_token", accessToken);
        userInfoParam.put("code", code);
        if (log.isInfoEnabled())
            log.info("getUser,地址：{},代理信息：{}:{},参数:{}", URL_USER_ID, host, port, JSONUtil.toJsonStr(userInfoParam));
        // String userInfoStr = HttpUtil.get(URL_USER_ID, userInfoParam, 10 * 1000);
        String userInfoStr = HttpRequest.get(URL_USER_ID)
                .setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(host, port)))
                .form(userInfoParam)
                .timeout(10 * 1000)
                .execute().body();
        if (log.isInfoEnabled())
            log.info("getUser,结果:{}", userInfoStr);
        return userInfoStr;
    }
}
