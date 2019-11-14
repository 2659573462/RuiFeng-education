package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/14 15:59
 */
@Data
public class TeacherTable {
    /**
     * 讲师id
     */
    private Integer teacherId;

    /**
     * 讲师姓名
     */
    private String teacherName;

    /**
     * 讲师简介
     */
    private String teacherInfo;

    /**
     * 教学特点
     */
    private String teacherCharacteristics;

    /**
     * 讲师授课学科
     */
    private String teacherDirection;

    /**
     * 讲师上传视频
     */
    private String teacherVideo;

    /**
     * 讲师默认头像
     */
    private String teacherHeadportrait;
}