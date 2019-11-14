package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.OrdeTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/5 14:16
 */
public interface OrdeTableService {


    int deleteByPrimaryKey(Integer ordeId);

    int insert(OrdeTable record);

    int insertSelective(OrdeTable record);

    OrdeTable selectByPrimaryKey(Integer ordeId);

    int updateByPrimaryKeySelective(OrdeTable record);

    int updateByPrimaryKey(OrdeTable record);

    OrdeTable selectUsername(String string);
}

