package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import org.springframework.stereotype.Service;

/**
 * 登录获取数据service
 *
 * @author chenjin
 * @date 2019/11/10 15:50
 */
public interface LoginGetDataService {
    /**
     * 查询精品套装
     * @return
     */
    CourseintroductionTable selectBoutique(String type);
}
