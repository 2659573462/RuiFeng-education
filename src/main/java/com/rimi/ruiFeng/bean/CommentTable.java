package com.rimi.ruiFeng.bean;

import lombok.Data;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 16:14
 */
@Data
public class CommentTable {
    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 评论对应的视频编码
     */
    private String commentCoding;

    /**
     * 评论对应用户的id
     */
    private String commentUser;

    /**
     * 评论的时间
     */
    private String commentTime;

    /**
     * 评论的内容
     */
    private String commentContent;
}