package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.MessageTable;
import com.rimi.ruiFeng.mapper.MessageTableMapper;
import com.rimi.ruiFeng.service.MessageTableService;
/**
 *${Description}
 *@author chenjin
 *@date 2019/11/7 16:22
 */
@Service
public class MessageTableServiceImpl implements MessageTableService{

    @Resource
    private MessageTableMapper messageTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer messageId) {
        return messageTableMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public int insert(MessageTable record) {
        return messageTableMapper.insert(record);
    }

    @Override
    public int insertSelective(MessageTable record) {
        return messageTableMapper.insertSelective(record);
    }

    @Override
    public MessageTable selectByPrimaryKey(Integer messageId) {
        return messageTableMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public int updateByPrimaryKeySelective(MessageTable record) {
        return messageTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MessageTable record) {
        return messageTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public MessageTable selectMobile(String numbers) {
        return messageTableMapper.selectMobile(numbers);
    }

    @Override
    public int updateMobile(String numbers, String verify) {
        return messageTableMapper.updateMessageMobile(numbers,verify);
    }

    @Override
    public MessageTable selectMobileAndVerificationoCde(String telephoneNumber, String authCode) {
        return messageTableMapper.selectMobileAndVerificationoCdes(telephoneNumber,authCode);
    }

}
