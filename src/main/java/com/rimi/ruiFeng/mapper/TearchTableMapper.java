package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.TearchTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 11:52
 */
public interface TearchTableMapper {
    int deleteByPrimaryKey(Integer tearchId);

    int insert(TearchTable record);

    int insertSelective(TearchTable record);

    TearchTable selectByPrimaryKey(Integer tearchId);

    int updateByPrimaryKeySelective(TearchTable record);

    int updateByPrimaryKey(TearchTable record);
}