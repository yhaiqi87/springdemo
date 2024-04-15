package com.example.demohttp;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

class DemoTests {

    @Test
    void contextLoads1() {
        System.out.println(StringUtils.strip("/api/member/group/", "/"));
    }

    @Test
    void contextLoads() {
        String[] text = {"喜", "兴", "發", "记", "合", "顺", "牌", "裕", "啫"};
        int length = text.length;
        m1(text, length);
        System.out.println("====================");
        m2(text, length);
        System.out.println("====================");
        m3(text, length);
    }

    private void m3(String[] text, int length) {
        int x = 0;
        for (int i = 0; i < length; i++) {
            String a = text[i];
            for (int j = 1; j < length; j++) {
                String b = text[j];
                for (int k = 0; k < length; k++) {
                    String c = text[k];
                    for (int l = 0; l < length; l++) {
                        String d = text[l];
                        System.out.print(String.join("", a, b, c, d) + " ");
                        x++;
                        if (x % 20 == 0) {
                            System.out.println();
                        }
                    }
                }
            }
            // System.out.println();
        }
    }

    private void m2(String[] text, int length) {
        int x = 0;
        for (int i = 0; i < length; i++) {
            String a = text[i];
            for (int j = 1; j < length; j++) {
                String b = text[j];
                for (int k = 0; k < length; k++) {
                    String c = text[k];
                    System.out.print(String.join("", a, b, c) + " ");
                    x++;
                    if (x % 20 == 0) {
                        System.out.println();
                    }
                }
            }
            // System.out.println();
        }
    }

    private static void m1(String[] text, int length) {
        // int k=0;
        for (int i = 0; i < length; i++) {
            String a = text[i];
            for (int j = 1; j < length; j++) {
                String b = text[j];
                System.out.print(String.join("", a, b) + " ");
                // k++;
                // if (k % length == 0) {
                //     System.out.println();
                // }
            }
            System.out.println();
        }
    }

}
