package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.ShopTable;
import com.rimi.ruiFeng.vo.SoppingVo;
import org.springframework.stereotype.Service;

/**
 * 加入购物车
 *
 * @author chenjin
 * @date 2019/11/12 16:46
 */
@Service
public interface InsertShoppingService {
    /**
     * 将商品加入用户的购物车
     * @param soppingVo
     * @return
     */
    int insertSoppings(SoppingVo soppingVo);

    /**
     * 获取购物车内的数据
     */
    ShopTable selectUsername(String userName);

    /**
     * 删除购物车中的商品
     */
    int deleteByOrderid(SoppingVo soppingVo);
}
