package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.common.Result;
import com.rimi.ruiFeng.vo.RegistUserVo;

/**
 * 注册逻辑
 *
 * @author chenjin
 * @date 2019/11/7 22:13
 */
public interface RegisterService {

    int insertUser(RegistUserVo registUserVo);

}
