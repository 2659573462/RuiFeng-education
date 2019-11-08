package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.TearchTable;
import com.rimi.ruiFeng.mapper.TearchTableMapper;
import com.rimi.ruiFeng.service.TearchTableService;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/5 14:17
 */
@Service
public class TearchTableServiceImpl implements TearchTableService {

    @Resource
    private TearchTableMapper tearchTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer tearchId) {
        return tearchTableMapper.deleteByPrimaryKey(tearchId);
    }

    @Override
    public int insert(TearchTable record) {
        return tearchTableMapper.insert(record);
    }

    @Override
    public int insertSelective(TearchTable record) {
        return tearchTableMapper.insertSelective(record);
    }

    @Override
    public TearchTable selectByPrimaryKey(Integer tearchId) {
        return tearchTableMapper.selectByPrimaryKey(tearchId);
    }

    @Override
    public int updateByPrimaryKeySelective(TearchTable record) {
        return tearchTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TearchTable record) {
        return tearchTableMapper.updateByPrimaryKey(record);
    }

}


