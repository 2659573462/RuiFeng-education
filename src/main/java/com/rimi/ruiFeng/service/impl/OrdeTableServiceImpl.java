package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.service.OrdeTableService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.mapper.OrdeTableMapper;
import com.rimi.ruiFeng.bean.OrdeTable;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:16
 */
@Service
public class OrdeTableServiceImpl implements OrdeTableService {

    @Resource
    private OrdeTableMapper ordeTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer ordeId) {
        return ordeTableMapper.deleteByPrimaryKey(ordeId);
    }

    @Override
    public int insert(OrdeTable record) {
        return ordeTableMapper.insert(record);
    }

    @Override
    public int insertSelective(OrdeTable record) {
        return ordeTableMapper.insertSelective(record);
    }

    @Override
    public OrdeTable selectByPrimaryKey(Integer ordeId) {
        return ordeTableMapper.selectByPrimaryKey(ordeId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrdeTable record) {
        return ordeTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrdeTable record) {
        return ordeTableMapper.updateByPrimaryKey(record);
    }

}
