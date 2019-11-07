package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.MessageTableMapper;
import com.rimi.ruiFeng.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/11/6 22:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-service.xml"})
public class LoginServiceImplTest {

    @Autowired
    private MessageTableMapper userTableServiceImpl;

    @Test
    public void selectUser() {
        User user = new User();
        user.setUsername("abc");
        user.setPassword("123");
        //UserTable userTable = loginService.selectUser(user);
        //System.out.println(userTable);
        MessageTable messageTable1 = new MessageTable();
        messageTable1.setMessageMobile("6592596261");
        int i = userTableServiceImpl.insert(messageTable1);
        System.out.println(i);
    }
}