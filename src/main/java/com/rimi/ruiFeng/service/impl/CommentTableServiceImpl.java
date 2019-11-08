package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.service.CommentTableService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.mapper.CommentTableMapper;
import com.rimi.ruiFeng.bean.CommentTable;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/5 13:03
 */
@Service
public class CommentTableServiceImpl implements CommentTableService {

    @Resource
    private CommentTableMapper commentTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return commentTableMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public int insert(CommentTable record) {
        return commentTableMapper.insert(record);
    }

    @Override
    public int insertSelective(CommentTable record) {
        return commentTableMapper.insertSelective(record);
    }

    @Override
    public CommentTable selectByPrimaryKey(Integer commentId) {
        return commentTableMapper.selectByPrimaryKey(commentId);
    }

    @Override
    public int updateByPrimaryKeySelective(CommentTable record) {
        return commentTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CommentTable record) {
        return commentTableMapper.updateByPrimaryKey(record);
    }

}


