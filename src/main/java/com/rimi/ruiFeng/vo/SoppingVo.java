package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 购物传入的对象
 *
 * @author chenjin
 * @date 2019/11/12 16:38
 */
@Data
public class SoppingVo {
    /**
     * 验证身份的动态参数
     */
    private String verification;
    /**
     * 传入的数据为字符串
     */
    private String commoditys;
    /**
     * 传入的数据为数组
     */
    private String[] commoditysSopping;
}
