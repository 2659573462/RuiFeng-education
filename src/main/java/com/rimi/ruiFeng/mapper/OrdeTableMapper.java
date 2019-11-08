package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.OrdeTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 16:05
 */
public interface OrdeTableMapper {
    int deleteByPrimaryKey(Integer ordeId);

    int insert(OrdeTable record);

    int insertSelective(OrdeTable record);

    OrdeTable selectByPrimaryKey(Integer ordeId);

    int updateByPrimaryKeySelective(OrdeTable record);

    int updateByPrimaryKey(OrdeTable record);
}