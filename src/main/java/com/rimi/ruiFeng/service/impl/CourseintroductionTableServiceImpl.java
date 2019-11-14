package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.mapper.CourseintroductionTableMapper;
import com.rimi.ruiFeng.service.CourseintroductionTableService;

import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/10 15:48
 */
@Service
public class CourseintroductionTableServiceImpl implements CourseintroductionTableService {

    @Resource
    private CourseintroductionTableMapper courseintroductionTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer courseintroductionId) {
        return courseintroductionTableMapper.deleteByPrimaryKey(courseintroductionId);
    }

    @Override
    public int insert(CourseintroductionTable record) {
        return courseintroductionTableMapper.insert(record);
    }

    @Override
    public int insertSelective(CourseintroductionTable record) {
        return courseintroductionTableMapper.insertSelective(record);
    }

    @Override
    public CourseintroductionTable selectByPrimaryKey(Integer courseintroductionId) {
        return courseintroductionTableMapper.selectByPrimaryKey(courseintroductionId);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseintroductionTable record) {
        return courseintroductionTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourseintroductionTable record) {
        return courseintroductionTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CourseintroductionTable> selectType(String type) {
        return courseintroductionTableMapper.selectType(type);
    }

    @Override
    public List<CourseintroductionTable> selectAllSuit() {
        return courseintroductionTableMapper.selectAllSuit();
    }

    @Override
    public List selectASingle(String distinction) {
        return courseintroductionTableMapper.selectASingle(distinction);
    }

    @Override
    public List selectASingleNo( ) {
        return courseintroductionTableMapper.selectASingleNo();
    }

    @Override
    public List<CourseintroductionTable> selectLearningType(String learningType) {
        return courseintroductionTableMapper.selectLearningType(learningType);
    }

    @Override
    public CourseintroductionTable selectDistinction(String distinction) {
        return courseintroductionTableMapper.selectDistinction(distinction);
    }

    @Override
    public CourseintroductionTable selectCRCcomment(String distinction) {
        return courseintroductionTableMapper.selectCRCcomment(distinction);
    }

    @Override
    public  List<CourseintroductionTable> selectCRCcomment() {
        return courseintroductionTableMapper.selectAllVideoData();
    }


}



