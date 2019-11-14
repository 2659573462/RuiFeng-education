package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/14 1:54
 */
@Data
public class VideotimeTable {
    /**
     * 用户观看视频的历史记录id
     */
    private Integer videotiemId;

    /**
     * 存储观看视频的唯一编码
     */
    private String videotimeVideoid;

    /**
     * 存储视频最后一次观看的时间
     */
    private String videotimeTime;

    /**
     * 用户id
     */
    private String videotimeUser;

    /**
     * 属于那一套
     */
    private String videotimeCourseintroduction;
}