package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.mapper.CourseintroductionTableMapper;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.mapper.VideoTableMapper;
import com.rimi.ruiFeng.service.LoginGetDataService;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.util.VerificationLogin;
import com.rimi.ruiFeng.vo.RequestASingleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenjin
 * @date 2019/11/10 16:00
 */
@Service
public class LoginGetDataServiceImpl implements LoginGetDataService {

    @Autowired
    private CourseintroductionTableMapper courseintroductionTableMapper;

    @Autowired
    private UserTableMapper userTableMapper;

    @Autowired
    private VideoTableMapper videoTableMapper;


    /**
     * 查询精品套装
     * @param type :如精品
     * @return
     */
    @Override
    public List<CourseintroductionTable> selectBoutique(String type) {
        return courseintroductionTableMapper.selectType(type);
    }
    /**
     *
     * 返回所有的商品套装
     * @return
     */
    @Override
    public List<CourseintroductionTable> selectAllSuitService(RequestASingleVo requestASingleVo) {
        String statusode = requestASingleVo.getStatusode();
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(statusode);
        if(!verifcation){
            return null;
        }else{
            List<CourseintroductionTable> type = courseintroductionTableMapper.selectAllSuit();
            return type;
        }
    }


    /**
     * A301C3651655: 所有的视频
     * 返回个同一套的所有数据
     */
    @Override
    public List<VideoTable> selectASuits(RequestASingleVo requestASingleVo){
        String statusode = requestASingleVo.getStatusode();
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(statusode);
        String content = requestASingleVo.getContent();
        List<VideoTable> videoTables = videoTableMapper.selectAllSuit(content);
        if(!verifcation&&videoTables==null){
            return null;
        }else{
            return videoTables;
        }
    }

    /**
     * 如:java 返回所有java套
     * 同一个方向返回所有的套
     * @param requestASingleVo
     * @return
     */
    @Override
    public List<CourseintroductionTable> selectAllType(RequestASingleVo requestASingleVo) {
        String statusode = requestASingleVo.getStatusode();
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(statusode);
        List<CourseintroductionTable> courseintroductionTables = courseintroductionTableMapper.selectType(requestASingleVo.getParameter());
        if(!verifcation&&courseintroductionTables==null){
            return null;
        }else {
            return courseintroductionTables;
        }
    }

    /**
     * 查询用户个人信息
     * @param verification
     * @return
     */
    @Override
    public UserTable selectUsername(String verification) {
        if(verification==null){
            return null;
        }else {
            String[] strings = UtilString.InterceptString(verification);
            System.out.println(strings[0]);
            return userTableMapper.selectUsername(strings[0]);
        }
    }

}
