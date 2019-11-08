package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.VideotimeTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/6 19:57
 */
public interface VideotimeTableService {


    int deleteByPrimaryKey(Integer videotiemId);

    int insert(VideotimeTable record);

    int insertSelective(VideotimeTable record);

    VideotimeTable selectByPrimaryKey(Integer videotiemId);

    int updateByPrimaryKeySelective(VideotimeTable record);

    int updateByPrimaryKey(VideotimeTable record);

}


