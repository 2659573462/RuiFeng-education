package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.VideotimeTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 15:37
 */
public interface VideotimeTableMapper {
    int deleteByPrimaryKey(Integer videotiemId);

    int insert(VideotimeTable record);

    int insertSelective(VideotimeTable record);

    VideotimeTable selectByPrimaryKey(Integer videotiemId);

    int updateByPrimaryKeySelective(VideotimeTable record);

    int updateByPrimaryKey(VideotimeTable record);
}