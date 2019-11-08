package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 15:49
 */
@Data
public class VideoTable {
    /**
     * 视频id
     */
    private Integer videoId;

    /**
     * 视频区分唯一的编码
     */
    private String videoCoding;

    /**
     * 视频讲师
     */
    private String videoTearch;

    /**
     * 观看人数
     */
    private String videoWatchnumber;

    /**
     * 区别视频套装的字段
     */
    private String videoSuit;

    /**
     * 视频学习方向类型也就是属于那一套中的视频
     */
    private String videoSubject;

    /**
     * 视频章节
     */
    private String videoChapter;

    /**
     * 视频简介
     */
    private String videoIntroduce;

    /**
     * 视频类型(付费还是免费)
     */
    private String videoPricetype;

    /**
     * 视频单价
     */
    private String videoPrice;

    /**
     * 视频折扣
     */
    private String videoDiscount;

    /**
     * 视频介绍缩略图对应虚拟机的地址
     */
    private String videoBreviarypicture;

    /**
     * 视频对应虚拟机的地址
     */
    private String videoSite;

    /**
     * 视频时长
     */
    private String videoChaptertiem;

    /**
     * 属于:java
     */
    private String videoCoursetitle;
}