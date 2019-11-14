package com.rimi.ruiFeng.vo;

import lombok.Data;

/**
 * 获取所有数据对象
 *
 * @author chenjin
 * @date 2019/11/11 11:46
 */
@Data
public class RequestASingleVo {
    /**
     * 状态码
     */
    private String statusode;
    /**
     * 请求的内容: 那一套之类的:A301C3651654
     */
    private String content;
    /**
     * 请求参数: 请求的是什么东西:精品
     */
    private String parameter;
}
