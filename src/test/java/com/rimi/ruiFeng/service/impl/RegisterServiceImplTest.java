package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.vo.RegistUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/11/7 22:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-service.xml"})
public class RegisterServiceImplTest {

    @Autowired
    private RegisterServiceImpl registUserVos;

    @Test
    public void insertUser() {
        RegistUserVo registUserVo = new RegistUserVo();
        registUserVo.setUsername("abc");
        registUserVo.setPassword("123");
        int i = registUserVos.insertUser(registUserVo);

    }
}