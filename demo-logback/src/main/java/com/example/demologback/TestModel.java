package com.example.demologback;

import lombok.Data;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/3/15 18:04
 */
@Data
public class TestModel {
    private String id;

    public TestModel() {
    }
    public TestModel(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id='" + id + '\'' +
                '}';
    }
}
