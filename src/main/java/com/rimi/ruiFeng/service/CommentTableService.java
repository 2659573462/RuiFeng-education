package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.CommentTable;
    /**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 13:03
 */
public interface CommentTableService{


    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentTable record);

    int insertSelective(CommentTable record);

    CommentTable selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommentTable record);

    int updateByPrimaryKey(CommentTable record);

}
