package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.MessageTable;
    /**
 *${Description}
 *@author chenjin
 *@date 2019/11/7 16:22
 */
public interface MessageTableService{


    int deleteByPrimaryKey(Integer messageId);

    int insert(MessageTable record);

    int insertSelective(MessageTable record);

    MessageTable selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MessageTable record);

    int updateByPrimaryKey(MessageTable record);

    MessageTable selectMobile(String numbers);

    int updateMobile(String numbers,String verify);


    MessageTable selectMobileAndVerificationoCde(String telephoneNumber, String authCode);
    }
