package com.example.demomybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demomybatisplus.BaseAppTest;
import com.example.demomybatisplus.domain.DsMemberMember;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
class DsMemberMemberServiceTest extends BaseAppTest {
    @Autowired
    DsMemberMemberService service;

    @Test
    public void t1() {
        LambdaQueryWrapper<DsMemberMember> queryWrapper = new LambdaQueryWrapper<>();
        Page<DsMemberMember> page = new Page<>(1, 10);
        service.page(page, queryWrapper);
        List<DsMemberMember> records = page.getRecords();
        log.info(records.size() + "");

        DsMemberMember dsMemberMember = records.get(0);
        dsMemberMember.setUpdateTime(new Date());
        boolean b = service.updateById(dsMemberMember);
        log.info("更新结果：{}", b);
    }

}
