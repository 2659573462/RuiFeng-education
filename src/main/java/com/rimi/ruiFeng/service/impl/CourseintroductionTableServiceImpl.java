package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.mapper.CourseintroductionTableMapper;
import com.rimi.ruiFeng.service.CourseintroductionTableService;

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
    public CourseintroductionTable selectType(String type) {
        return courseintroductionTableMapper.selectType(type);
    }


}


