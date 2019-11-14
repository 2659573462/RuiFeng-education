package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.mapper.MessageTableMapper;
import com.rimi.ruiFeng.service.LoginGetDataService;
import com.rimi.ruiFeng.service.VideoTableService;
import com.rimi.ruiFeng.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/11/11 11:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-service.xml"})
public class LoginGetDataTest {
    @Autowired
    private LoginGetDataService userTableServiceImpl;

    @Autowired
    private VideoTableService videoTableService;

    @Test
    public void selectUser() {
        //List<CourseintroductionTable> t = userTableServiceImpl.selectBoutique("精品");
        //for (CourseintroductionTable s:
        //     t) {
        //    System.out.println(s);
        //}

        List<VideoTable> videoAll= videoTableService.selectAllVideoData();
        for (VideoTable s:
        videoAll) {
            System.out.println(s);
        }
    }
}