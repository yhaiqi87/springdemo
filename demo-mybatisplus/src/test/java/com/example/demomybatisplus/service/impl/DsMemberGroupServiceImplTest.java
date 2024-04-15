package com.example.demomybatisplus.service.impl;

import com.example.demomybatisplus.BaseAppTest;
import com.example.demomybatisplus.domain.DsMemberGroup;
import com.example.demomybatisplus.service.DsMemberGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class DsMemberGroupServiceImplTest extends BaseAppTest {


    @Autowired
    DsMemberGroupService service;


    @Test
    void saveOrUpdate() {
        List<DsMemberGroup> list = service.list();
        System.out.println(list.toArray());
    }
}
