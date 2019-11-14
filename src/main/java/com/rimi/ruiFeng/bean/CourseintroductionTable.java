package com.rimi.ruiFeng.bean;

import lombok.Data;

import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/11 19:23
 */
@Data
public class CourseintroductionTable {
    /**
     * 视频套装的id
     */
    private Integer courseintroductionId;

    /**
     * 视频套装方向:java
     */
    private String courseintroductionType;

    /**
     * 视频的名称如:java入门精简
     */
    private String courseintroductionNarrate;

    /**
     * 视频套装的概述
     */
    private String courseintroductionSummarize;

    /**
     * 视频套装的应用场景
     */
    private String courseintroductionApplication;

    /**
     * 视频套装的实际意义
     */
    private String courseintroductionSignificance;

    /**
     * 套装的所属大学类似出版社的感觉
     */
    private String courseintroductionUniversity;

    /**
     * 区别套装的唯一字段
     */
    private String courseintroductionDistinction;

    /**
     * 视频套装的评分
     */
    private String courseintroductionGrade;

    /**
     * 精品
     */
    private String courseintroductionBoutique;

    /**
     * 讲师
     */
    private String courseintroductionTeacher;

    /**
     * 观看人数
     */
    private String courseintroductionWatchnumber;

    /**
     * 单价
     */
    private String courseintroductionPrice;

    /**
     * 折扣
     */
    private String courseintroductionDiscount;

    /**
     * 视频套装对应虚拟机缩略图的地址
     */
    private String courseintroductionBreviarypictyre;

    /**
     * 视频套装对应虚拟机缩略图的地址App 移动
     */
    private String courseintroductionBreviarypictyreapp;

    /**
     * 视频套装的总时长
     */
    private String courseintroductionTotaltime;

    /**
     * 一套视频含的多个子视频
     */
    private List<VideoTable> selectAllVideoData;

    /**
     * 讲师对象
     */
    private TeacherTable teacherTables;
}