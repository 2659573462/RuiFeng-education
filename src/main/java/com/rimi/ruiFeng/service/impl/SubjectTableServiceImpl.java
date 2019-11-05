package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.SubjectTable;
import com.rimi.ruiFeng.mapper.SubjectTableMapper;
import com.rimi.ruiFeng.service.SubjectTableService;
/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
@Service
public class SubjectTableServiceImpl implements SubjectTableService{

    @Resource
    private SubjectTableMapper subjectTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer subjectId) {
        return subjectTableMapper.deleteByPrimaryKey(subjectId);
    }

    @Override
    public int insert(SubjectTable record) {
        return subjectTableMapper.insert(record);
    }

    @Override
    public int insertSelective(SubjectTable record) {
        return subjectTableMapper.insertSelective(record);
    }

    @Override
    public SubjectTable selectByPrimaryKey(Integer subjectId) {
        return subjectTableMapper.selectByPrimaryKey(subjectId);
    }

    @Override
    public int updateByPrimaryKeySelective(SubjectTable record) {
        return subjectTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SubjectTable record) {
        return subjectTableMapper.updateByPrimaryKey(record);
    }

}
