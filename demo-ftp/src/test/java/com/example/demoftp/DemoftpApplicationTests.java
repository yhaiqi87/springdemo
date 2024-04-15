package com.example.demoftp;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

@SpringBootTest
class DemoftpApplicationTests {
    public static final String ZSET_K_2 = "zset:k3";
    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    @Test
    void testZset1() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        System.out.println(JSONUtil.toJsonStr(zSetOperations.range(ZSET_K_2, 0, 5)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.range(ZSET_K_2, 0, 10)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.rangeWithScores(ZSET_K_2, 0, 5)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.rangeWithScores(ZSET_K_2, 0, 10)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.reverseRange(ZSET_K_2, 0, 5)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.reverseRange(ZSET_K_2, 0, 10)));
        System.out.println(JSONUtil.toJsonStr(zSetOperations.popMax(ZSET_K_2, 2)));
    }

    @Test
    void testZset() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        for (int i = 0; i < 20; i++) {
            int score = RandomUtil.randomInt(999);
            zSetOperations.add(ZSET_K_2, score, score);
        }
    }

    @Test
    void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        for (int i = 0; i < 10; i++) {
            hash.put("hash:k1", "field:" + RandomUtil.randomInt(10), RandomUtil.randomString(6));
        }
    }

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForValue().set("string:" + RandomUtil.randomString(5), RandomUtil.randomInt(9999));
        }
    }

}
