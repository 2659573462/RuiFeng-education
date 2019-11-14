package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.TeacherTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/14 15:59
 */
public interface TeacherTableMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(TeacherTable record);

    int insertSelective(TeacherTable record);

    TeacherTable selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(TeacherTable record);

    int updateByPrimaryKey(TeacherTable record);
}