package com.example.demomybatisplus;

import cn.hutool.core.io.resource.ResourceUtil;

public class AsssTest {
    public static void main(String[] args) {
        //System.out.println(JSON.toJSONString("111"));
        //System.out.println(JSON.toJSONString(1));
        //System.out.println(JSON.toJSONString("1L"));
        //System.out.println(JSON.toJSONString(1.1111));
        //System.out.println(JSON.toJSONString("[111,222]"));
        //System.out.println(JSON.toJSONString("["));


        System.out.println(ResourceUtil.readUtf8Str("mapper/DsMemberGroupMapper.xml"));
    }
}
