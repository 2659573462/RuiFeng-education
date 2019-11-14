package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.mapper.VideoTableMapper;
import com.rimi.ruiFeng.service.VideoTableService;

import java.util.List;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/5 14:17
 */
@Service
public class VideoTableServiceImpl implements VideoTableService {

    @Resource
    private VideoTableMapper videoTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer videoId) {
        return videoTableMapper.deleteByPrimaryKey(videoId);
    }

    @Override
    public int insert(VideoTable record) {
        return videoTableMapper.insert(record);
    }

    @Override
    public int insertSelective(VideoTable record) {
        return videoTableMapper.insertSelective(record);
    }

    @Override
    public VideoTable selectByPrimaryKey(Integer videoId) {
        return videoTableMapper.selectByPrimaryKey(videoId);
    }

    @Override
    public int updateByPrimaryKeySelective(VideoTable record) {
        return videoTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(VideoTable record) {
        return videoTableMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<VideoTable> selectAllVideoData() {
        return videoTableMapper.selectAllVideoData();
    }

    @Override
    public List selectAllSuit(String parameter) {
        return videoTableMapper.selectAllSuit(parameter);
    }

    @Override
    public List<VideoTable> selectAllSuitComment(String parameter) {
        return videoTableMapper.selectAllSuitComment(parameter);
    }

}



