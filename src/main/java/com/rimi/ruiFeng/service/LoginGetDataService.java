package com.rimi.ruiFeng.service;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.vo.RequestASingleVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登录获取数据service
 *
 * @author chenjin
 * @date 2019/11/10 15:50
 */
@Service
public interface LoginGetDataService {
    /**
     * 查询精品套装
     * @return
     */
    List<CourseintroductionTable> selectBoutique(String type);

    /**
     * 返回所有的视频套装
     */
    List<CourseintroductionTable> selectAllSuitService(RequestASingleVo requestASingleVo);

    /**
     * 返回同一套的所有视频
     * @param requestASingleVo
     * @return
     */
    List<VideoTable> selectASuits(RequestASingleVo requestASingleVo);

    /**
     * 同一学习方向返回所有的套装
     */
    List<CourseintroductionTable> selectAllType(RequestASingleVo requestASingleVo);

    /**
     * 获取用户的个人信息
     * @param verification
     * @return
     */
    UserTable selectUsername(String verification);
}
