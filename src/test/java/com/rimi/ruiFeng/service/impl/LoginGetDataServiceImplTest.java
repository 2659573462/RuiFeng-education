package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.vo.RequestASingleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenjin
 * @date 2019/11/12 15:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-service.xml"})
public class LoginGetDataServiceImplTest {


    @Autowired
    private LoginGetDataServiceImpl registUserVos;

    @Test
    public void selectBoutique() {
    }

    @Test
    public void selectAllSuitService() {
        RequestASingleVo requestASingleVo = new RequestASingleVo();
        requestASingleVo.setStatusode("cO3xJ4w9NBZeSXABG0OnTlrtXUS0XDG5ysMMd3gu9N0=,+XNvqgIKBiD1YjI1K0SSRrQFj+g/xyv9OAy8iwWD45A=");
        List<CourseintroductionTable> courseintroductionTables = registUserVos.selectAllSuitService(requestASingleVo);
        for (CourseintroductionTable s:
        courseintroductionTables) {
            System.out.println(s);
        }
    }

    @Test
    public void selectASuits() {
        RequestASingleVo requestASingleVo = new RequestASingleVo();
        requestASingleVo.setStatusode("cO3xJ4w9NBZeSXABG0OnTlrtXUS0XDG5ysMMd3gu9N0=,+XNvqgIKBiD1YjI1K0SSRrQFj+g/xyv9OAy8iwWD45A=");
        requestASingleVo.setContent("A301C3651655");
        List<VideoTable> videoTables = registUserVos.selectASuits(requestASingleVo);
        for (VideoTable s:
                videoTables) {
            System.out.println(s);
        }
    }
}