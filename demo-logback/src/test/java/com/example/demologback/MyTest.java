package com.example.demologback;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/3/15 18:02
 */
public class MyTest {

    @Test
    public void test3() {
        System.out.println(new Date(1695027611116L));
        System.out.println(new Date(1695027622741L));
    }

    @Test
    public void test2() {
        ArrayList<String> objects = new ArrayList<>();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            objects.add(RandomUtil.randomString(4));
            long l1 = System.currentTimeMillis();
            System.out.println("第" + (i + 1) + "次耗时：" + (l1 - l) + "ms");
            l = l1;
        }
    }

    @Test
    public void test1() {
        Set<String> groupIds = getTestModels(true)
                .stream()
                .filter(testModel -> testModel != null && StringUtils.hasText(testModel.getId()))
                .map(TestModel::getId)
                .collect(Collectors.toSet());
        System.out.println(groupIds);
    }

    private static ArrayList<TestModel> getTestModels(boolean isNull) {
        ArrayList<TestModel> testModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestModel testModel = new TestModel(i + "-" + RandomUtil.randomString(3));
            if (i == 1) {
                testModel.setId(null);
                testModel = null;
            }
            testModels.add(testModel);
        }
        System.out.println(testModels);
//        if (isNull) {
//            return null;
//        }
        return testModels;
    }
}
