package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.MessageTable;import org.apache.ibatis.annotations.Param;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 9:21
 */
public interface MessageTableMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(MessageTable record);

    int insertSelective(MessageTable record);

    MessageTable selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MessageTable record);

    int updateByPrimaryKey(MessageTable record);

    MessageTable selectMobile(String numbers);

    int updateMessageMobile(@Param("numbers") String numbers, @Param("verify") String verify,@Param("time")String time);

    MessageTable selectMobileAndVerificationoCdes(@Param("telephoneNumber") String telephoneNumber, @Param("authCode") String authCode);
}