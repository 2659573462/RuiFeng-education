package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.mapper.TeacherTableMapper;
import com.rimi.ruiFeng.bean.TeacherTable;
import com.rimi.ruiFeng.service.TeacherTableService;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 16:24
 */
@Service
public class TeacherTableServiceImpl implements TeacherTableService {

    @Resource
    private TeacherTableMapper teacherTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer teacherId) {
        return teacherTableMapper.deleteByPrimaryKey(teacherId);
    }

    @Override
    public int insert(TeacherTable record) {
        return teacherTableMapper.insert(record);
    }

    @Override
    public int insertSelective(TeacherTable record) {
        return teacherTableMapper.insertSelective(record);
    }

    @Override
    public TeacherTable selectByPrimaryKey(Integer teacherId) {
        return teacherTableMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public int updateByPrimaryKeySelective(TeacherTable record) {
        return teacherTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TeacherTable record) {
        return teacherTableMapper.updateByPrimaryKey(record);
    }

}

