package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.TearchTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/5 14:17
 */
public interface TearchTableService {


    int deleteByPrimaryKey(Integer tearchId);

    int insert(TearchTable record);

    int insertSelective(TearchTable record);

    TearchTable selectByPrimaryKey(Integer tearchId);

    int updateByPrimaryKeySelective(TearchTable record);

    int updateByPrimaryKey(TearchTable record);

}


