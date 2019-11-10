package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.service.CourseintroductionTableService;
import com.rimi.ruiFeng.service.LoginGetDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenjin
 * @date 2019/11/10 16:00
 */
@Service
public class LoginGetDataServiceImpl implements LoginGetDataService {

    @Resource
    private CourseintroductionTableService courseintroductionTableService;


    /**
     * 查询精品套装
     * @param type :如精品
     * @return
     */
    @Override
    public CourseintroductionTable selectBoutique(String type) {
        return courseintroductionTableService.selectType(type);
    }
}
