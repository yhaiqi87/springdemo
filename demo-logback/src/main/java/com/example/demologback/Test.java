package com.example.demologback;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

public class Test {

    public static void main(String[] args) {
        Snowflake snowflake = IdUtil.getSnowflake();
        System.out.println(snowflake.nextId());
        System.out.println(snowflake.nextIdStr());
        System.out.println(IdUtil.getSnowflake(1, 1).nextId());
        System.out.println(IdUtil.getSnowflake(1, 1).nextIdStr());
        System.out.println(IdUtil.getSnowflake(1, 1).nextId());
        System.out.println(IdUtil.getSnowflake(1, 1).nextIdStr());
        System.out.println(Convert.toHex(snowflake.nextIdStr(), CharsetUtil.CHARSET_UTF_8));
        //System.out.println(Convert.hexToStr("5ROSji", Charset.defaultCharset()));
        System.out.println(RandomUtil.randomString(8));
        System.out.println(RandomUtil.randomString(8));
        System.out.println(RandomUtil.randomString(8));
        System.out.println(RandomUtil.randomString(8));
        System.out.println(RandomUtil.randomString(8));
        System.out.println(RandomUtil.randomString(8));
    }

    public void print(boolean flag) {

        if (flag) {
            System.out.println("我是if语句的分支");
        } else {
            System.out.println("我是else语句的分支");
        }
    }
}
