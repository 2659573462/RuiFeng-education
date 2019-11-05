package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.VideoTable;
    /**
 *${Description}
 *@author chenjin
 *@date 2019/11/5 14:17
 */
public interface VideoTableService{


    int deleteByPrimaryKey(Integer videoId);

    int insert(VideoTable record);

    int insertSelective(VideoTable record);

    VideoTable selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(VideoTable record);

    int updateByPrimaryKey(VideoTable record);

}
