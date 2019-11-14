package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.TeacherTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 16:24
 */
public interface TeacherTableService {


    int deleteByPrimaryKey(Integer teacherId);

    int insert(TeacherTable record);

    int insertSelective(TeacherTable record);

    TeacherTable selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(TeacherTable record);

    int updateByPrimaryKey(TeacherTable record);

}

