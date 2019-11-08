package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 11:52
 */
@Data
public class TearchTable {
    /**
     * 讲师id
     */
    private Integer tearchId;

    /**
     * 讲师姓名
     */
    private String tearchName;

    /**
     * 讲师简介
     */
    private String tearchInfo;

    /**
     * 教学特点
     */
    private String tearchHead;

    /**
     * 讲师授课学科
     */
    private String tearchDirection;

    /**
     * 讲师上传视频
     */
    private String tearchVideo;

    /**
     * 讲师默认头像
     */
    private String tearchHeadportrait;
}