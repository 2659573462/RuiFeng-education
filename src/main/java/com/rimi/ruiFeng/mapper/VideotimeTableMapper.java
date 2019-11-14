package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.VideotimeTable;import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/14 1:54
 */
public interface VideotimeTableMapper {
    int deleteByPrimaryKey(Integer videotiemId);

    int insert(VideotimeTable record);

    int insertSelective(VideotimeTable record);

    VideotimeTable selectByPrimaryKey(Integer videotiemId);

    int updateByPrimaryKeySelective(VideotimeTable record);

    int updateByPrimaryKey(VideotimeTable record);

    List<VideotimeTable> selectUsername(String string);
}