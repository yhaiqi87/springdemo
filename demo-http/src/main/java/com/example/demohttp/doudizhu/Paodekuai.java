package com.example.demohttp.doudizhu;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2024/2/7 17:15
 */
@Slf4j
public class Paodekuai {

    public static void main(String[] args) {
        List<String> colorList = ListUtil.of("黑桃", "红桃", "梅花", "方块");
        List<Poker> list = new ArrayList<>();
        for (String color : colorList) {
            for (int i = 1; i <= 13; i++) {
                list.add(new Poker(i, genName(i), color));
            }
        }
        list.add(new Poker(14, "王", "小"));
        list.add(new Poker(15, "王", "大"));
        log.info("list.size={}", list.size());
        log.info("list={}", JSONUtil.toJsonStr(list));
        Collections.shuffle(list);
        log.info("list={}", JSONUtil.toJsonStr(list));
    }

    private static String genName(int i) {
        String name;
        switch (i) {
            case 1:
                name = "A";
                break;
            case 11:
                name = "J";
                break;
            case 12:
                name = "Q";
                break;
            case 13:
                name = "K";
                break;
            default:
                name = String.valueOf(i);
        }
        return name;
    }
}
