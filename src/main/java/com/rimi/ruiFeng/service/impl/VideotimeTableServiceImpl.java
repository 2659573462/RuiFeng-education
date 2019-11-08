package com.rimi.ruiFeng.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rimi.ruiFeng.mapper.VideotimeTableMapper;
import com.rimi.ruiFeng.bean.VideotimeTable;
import com.rimi.ruiFeng.service.VideotimeTableService;

/**
 * ${Description}
 *
 * @author chenjin
 * @date 2019/11/6 19:57
 */
@Service
public class VideotimeTableServiceImpl implements VideotimeTableService {

    @Resource
    private VideotimeTableMapper videotimeTableMapper;

    @Override
    public int deleteByPrimaryKey(Integer videotiemId) {
        return videotimeTableMapper.deleteByPrimaryKey(videotiemId);
    }

    @Override
    public int insert(VideotimeTable record) {
        return videotimeTableMapper.insert(record);
    }

    @Override
    public int insertSelective(VideotimeTable record) {
        return videotimeTableMapper.insertSelective(record);
    }

    @Override
    public VideotimeTable selectByPrimaryKey(Integer videotiemId) {
        return videotimeTableMapper.selectByPrimaryKey(videotiemId);
    }

    @Override
    public int updateByPrimaryKeySelective(VideotimeTable record) {
        return videotimeTableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(VideotimeTable record) {
        return videotimeTableMapper.updateByPrimaryKey(record);
    }

}


