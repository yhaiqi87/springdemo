package com.example.demomybatisplus.service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demomybatisplus.BaseAppTest;
import com.example.demomybatisplus.domain.DsMemberMember;
import com.example.demomybatisplus.service.DsMemberMemberService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Slf4j
class DsMemberMemberServiceImplTest extends BaseAppTest {
    @Autowired
    DsMemberMemberService service;

    @Test
    void save() {
        DsMemberMember entity = new DsMemberMember();
        String memberId = new ObjectId().toHexString();
        entity.setMemberId(memberId);
        entity.setAddress(Arrays.asList("ee", "ww", "qq"));
        entity.setOrgId(memberId);
        entity.setStatus(0);
        entity.setMemberType(2);
        String s = JSONUtil.toJsonStr(entity);
        System.out.println(s);
        boolean save = service.save(entity);
        System.out.println(save);
    }

    @Test
    void listMaps() {
        LambdaQueryWrapper<DsMemberMember> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(DsMemberMember::getMemberId, DsMemberMember::getPhone, DsMemberMember::getCreateTime
                , DsMemberMember::getAddress
                , DsMemberMember::getOrgId, DsMemberMember::getUserId
                , DsMemberMember::getLabels
                //, DsMemberMember::getGroups
        );
        queryWrapper.eq(DsMemberMember::getPhone, "13023158317");

        //List<Map<String, Object>> list = service.listMaps(queryWrapper);
        //log.info(list.size() + "");
        //log.info(JSONUtil.toJsonStr(list));

        List<DsMemberMember> list1 = service.list(queryWrapper);
        log.info(list1.size() + "");
        log.info(JSONUtil.toJsonStr(list1));
    }
}
