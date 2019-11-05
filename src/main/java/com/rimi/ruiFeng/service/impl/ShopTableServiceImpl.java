package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.mapper.ShopTableMapper;
import com.rimi.ruiFeng.bean.ShopTable;
import com.rimi.ruiFeng.service.ShopTableService;
/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
@Service
public class ShopTableServiceImpl implements ShopTableService{

    @Resource
    private ShopTableMapper shopTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer shopId) {
        return shopTableMapper.deleteByPrimaryKey(shopId);
    }

    @Override
    public int insert(ShopTable record) {
        return shopTableMapper.insert(record);
    }

    @Override
    public int insertSelective(ShopTable record) {
        return shopTableMapper.insertSelective(record);
    }

    @Override
    public ShopTable selectByPrimaryKey(Integer shopId) {
        return shopTableMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public int updateByPrimaryKeySelective(ShopTable record) {
        return shopTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ShopTable record) {
        return shopTableMapper.updateByPrimaryKey(record);
    }

}
