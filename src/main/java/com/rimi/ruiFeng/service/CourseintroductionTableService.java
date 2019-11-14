package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.CourseintroductionTable;

import java.util.List;

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

    List<CourseintroductionTable> selectType(String type);

    List<CourseintroductionTable> selectAllSuit();

    List selectASingle(String distinction);

    List selectASingleNo();

    List<CourseintroductionTable> selectLearningType(String content);

    CourseintroductionTable selectDistinction(String distinction);

    CourseintroductionTable selectCRCcomment(String distinction);

    List<CourseintroductionTable> selectCRCcomment();
}



