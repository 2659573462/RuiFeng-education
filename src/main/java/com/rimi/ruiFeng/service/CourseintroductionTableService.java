package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.CourseintroductionTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/10 15:48
 */
public interface CourseintroductionTableService {


    int deleteByPrimaryKey(Integer courseintroductionId);

    int insert(CourseintroductionTable record);

    int insertSelective(CourseintroductionTable record);

    CourseintroductionTable selectByPrimaryKey(Integer courseintroductionId);

    int updateByPrimaryKeySelective(CourseintroductionTable record);

    int updateByPrimaryKey(CourseintroductionTable record);

    CourseintroductionTable selectType(String type);
}


