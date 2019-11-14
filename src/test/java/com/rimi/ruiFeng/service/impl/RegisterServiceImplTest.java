package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.vo.RegistUserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

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

    @Autowired
    private  MessageTableServiceImpl messageTable;

    @Test
    public void insertUser() {
        MessageTable messageTable = this.messageTable.selectMobile("42452452445");
        System.out.println(System.currentTimeMillis());
        String messageTime = messageTable.getMessageTime();
        Date d1 = new Date(Long.parseLong(messageTime)-3000000);
        Date d2 = new Date(System.currentTimeMillis());
        //前面大返回 大于0    前面小返回小于0
        System.out.println(d1.compareTo(d2));

    }
}