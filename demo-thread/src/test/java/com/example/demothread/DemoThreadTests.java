package com.example.demothread;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class DemoThreadTests {

    @SneakyThrows
    @Test
    void contextLoads() {
        System.out.println("执行启动");
        Thread t1 = new Thread(() -> {
            System.out.println("hello1");
            demoOpr(Thread.currentThread().getName(), 2);
        }, "t1");
        Thread t2 = new Thread(() -> {
            System.out.println("hello2");
            demoOpr(Thread.currentThread().getName(), 4);
        }, "t2");
        System.out.println("线程启动");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("执行完了");
    }

    private static void demoOpr(String name, int i) {
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(name + "：模拟执行业务操作：" + i1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
