package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
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
    * 讲师授课学科
    */
    private String tearchDirection;

    /**
    * 讲师上传视频
    */
    private String tearchVideo;
}