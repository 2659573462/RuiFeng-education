package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.SubjectTable;
    /**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
public interface SubjectTableService{


    int deleteByPrimaryKey(Integer subjectId);

    int insert(SubjectTable record);

    int insertSelective(SubjectTable record);

    SubjectTable selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(SubjectTable record);

    int updateByPrimaryKey(SubjectTable record);

}
