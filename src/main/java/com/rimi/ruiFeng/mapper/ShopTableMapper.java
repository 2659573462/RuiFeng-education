package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.ShopTable;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
public interface ShopTableMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(ShopTable record);

    int insertSelective(ShopTable record);

    ShopTable selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(ShopTable record);

    int updateByPrimaryKey(ShopTable record);
}