package com.rimi.ruiFeng.mapper;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.VideoTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/8 15:49
 */
public interface VideoTableMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(VideoTable record);

    int insertSelective(VideoTable record);

    VideoTable selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(VideoTable record);

    int updateByPrimaryKey(VideoTable record);

    List<VideoTable> selectAllVideoData();

    List<VideoTable> selectAllSuit(String parameter);

    List<VideoTable> selectAllSuitComment(@Param("parameter") String parameter);

    VideoTable selectACommentTable(String content);
}