package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.CourseintroductionTable;import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 19:23
 */
public interface CourseintroductionTableMapper {
    int deleteByPrimaryKey(Integer courseintroductionId);

    int insert(CourseintroductionTable record);

    int insertSelective(CourseintroductionTable record);

    CourseintroductionTable selectByPrimaryKey(Integer courseintroductionId);

    int updateByPrimaryKeySelective(CourseintroductionTable record);

    int updateByPrimaryKey(CourseintroductionTable record);

    List<CourseintroductionTable> selectType(String type);

    List<CourseintroductionTable> selectAllSuit();

    List<CourseintroductionTable> selectLearningType(String learningType);

    CourseintroductionTable selectDistinction(String distinction);

    List selectASingle(String distinction);

    CourseintroductionTable selectCRCcomment(String distinction);

    List<CourseintroductionTable> selectAllVideoData();

    List selectASingleNo();
}