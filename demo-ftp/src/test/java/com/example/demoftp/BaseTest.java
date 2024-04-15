package com.example.demoftp;

import cn.hutool.core.io.FileUtil;
import com.example.demoftp.jicheng.Animal;
import com.example.demoftp.jicheng.Dog;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/10/7 10:25
 */
@Slf4j
public class BaseTest {

    @Test
    public void test2() {
        String path = "C:/Users/yhaiq/下载";
        List<String> list = FileUtil.listFileNames(path).stream()
                .filter(o -> o.contains("uTools-4.4.1.7z"))
                .collect(Collectors.toList());
        System.out.println(list.size());
        for (String name : list) {
            boolean del = FileUtil.del(path + "/" + name);
            log.info("删除【{}】结果【{}】", name, del);
        }
    }

    @Test
    public void test1() {
        String x = "aaa";
        System.out.println(x.hashCode());
        String x1 = new String("aaa");
        System.out.println(x1.hashCode());
        System.out.println(x == x1);
        System.out.println(x.equals(x1));
        System.out.println(Animal.age);
        System.out.println(Dog.age);
        System.out.println(42 == 42.0);
        System.out.println(42L == 42.0);
        System.out.println(42L == 42.0f);
        // CacheManager cacheManager = new RedisCacheManager();
        // Cache cache = cacheManager.getCache("");
        // cache.evict();
        // Collection<String> cacheNames = cacheManager.getCacheNames();
    }
}
