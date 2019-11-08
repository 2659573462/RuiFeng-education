package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.CommentTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 16:14
 */
public interface CommentTableMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentTable record);

    int insertSelective(CommentTable record);

    CommentTable selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentTable record);

    int updateByPrimaryKey(CommentTable record);
}