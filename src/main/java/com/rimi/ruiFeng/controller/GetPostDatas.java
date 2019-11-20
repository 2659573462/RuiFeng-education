package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.bean.VideoTable;
import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.service.*;
import com.rimi.ruiFeng.service.impl.LoginGetDataServiceImpl;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.RequestASingleVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取数据,要数据
 *
 * @author chenjin
 * @date 2019/11/11 11:48
 */
@Api(tags = "登录成功获取视频参数的请求体")
@CrossOrigin
@RestController
public class GetPostDatas {

    private final LoginService loginService;
    private final MessageTableService messageTables;
    private final UserTableService userTableService;
    private final VideoTableService videoTableService;
    private final CourseintroductionTableService courseintroductionTableService;

    @Autowired
    private  LoginGetDataServiceImpl loginGetDataService;

    public GetPostDatas(LoginService loginService, MessageTableService messageTables,
                        UserTableService userTableService, VideoTableService videoTableService,
                        CourseintroductionTableService courseintroductionTableService) {
        this.loginService = loginService;
        this.userTableService =userTableService ;
        this.messageTables=messageTables;
        this.videoTableService = videoTableService;
        this.courseintroductionTableService=courseintroductionTableService;
    }

    /**
     * 获取所有的视频
     * @return
     */
    @PostMapping("/getAllVideoData")
    private ResultData getAllVideoData(){
        List<VideoTable> videoAll= videoTableService.selectAllVideoData();
        return new DefaultResultData(videoAll);
    }

    /**
     * 获取所有套
     * @return
     */
    @PostMapping("/getAllSuit")
    private ResultData getAllSuit(){
        List<CourseintroductionTable> type = courseintroductionTableService.selectCRCcomment();
        System.out.println(type);
        return new DefaultResultData(type);
    }


    /**
     * 获取单独的一套
     * @param requestASingleVo
     * @return
     */
    @PostMapping("/getASuit")
    private ResultData getASuit(@RequestBody  RequestASingleVo requestASingleVo){
        System.out.println(requestASingleVo.getContent());
        List types =null;
        String parameter = requestASingleVo.getContent();
        String statusode1 = requestASingleVo.getStatusode();
        if(statusode1==null || statusode1==""){
            types = videoTableService.selectAllSuit(parameter);
            return new DefaultResultData(types);
        }
        System.out.println(requestASingleVo);
        System.out.println(parameter);
        String statusode = requestASingleVo.getStatusode();
        //状态吗
        String[] strings = UtilString.InterceptString(statusode);
        UserTable userTable = userTableService.selectUsername(strings[0]);
        //用户购买
        String userByvideo = userTable.getUserByvideo();
        if(userByvideo==null){
            types = videoTableService.selectAllSuit(parameter);
            return new DefaultResultData(types);
        }
        String[] strings1 = UtilString.InterceptString(userByvideo);
        //输出要看的一套
        List list = videoTableService.selectAllSuit(parameter);
        for (int i = 0; i <strings1.length ; i++) {
            if(strings1[i].equals(parameter)){
                System.out.println("以加入状态");
                return new DefaultResultData(list,ResultCode.BOUGHT);
            }
        }

        return new DefaultResultData(list);
    }


    /**
     * 获取单个视频评论
     *
     */
    @PostMapping("/getComment")
    private ResultData getComment(@RequestBody  RequestASingleVo requestASingleVo){
        if(requestASingleVo.getContent()!=null ||requestASingleVo.getStatusode()!=null){
            return new DefaultResultData(ResultCode.ERROR_PARAMETER);
        }
        VideoTable video = videoTableService.selectCRCcomment(requestASingleVo.getContent());
        if(video==null){
            return new DefaultResultData(ResultCode.DESCRIPTION,"当前没有评论");
        }else{
            return new DefaultResultData(video);
        }
    }


    /**
     * 获取同一个方向的所有套
     * @param requestASingleVo
     * @return
     */
    @PostMapping("/getLearningType")
    private ResultData getLearningType(@RequestBody  RequestASingleVo requestASingleVo){
        String parameter = requestASingleVo.getContent();
        System.out.println(parameter);
        List<CourseintroductionTable> type = courseintroductionTableService.selectLearningType(requestASingleVo.getContent());
        return new DefaultResultData(type);
    }










    ///**
    // * 获取所有的视频内容,
    // * @param allVideoDataVo 需要传入一个状态码消息
    // * @return
    // */
    //@PostMapping("/getAllVideoData")
    //private ResultData getAllVideoData(@RequestBody RequestASingleVo allVideoDataVo){
    //    if(allVideoDataVo.getStatusode()!=null){
    //        //状态吗然后截取
    //        String statusode = allVideoDataVo.getStatusode();
    //        String[] split = statusode.split(",");
    //        UserTable user = userTableService.selectUserAndCorrection(split[0],allVideoDataVo.getStatusode());
    //        if(user!=null){
    //            List<VideoTable> videoAll= videoTableService.selectAllVideoData();
    //            return new DefaultResultData(videoAll);
    //        }else{
    //            return new DefaultResultData(ResultCode.ERROR_VERIFICATION_Expired);
    //        }
    //    }else{
    //        return new DefaultResultData(ResultCode.ERROR_PARAMETER);
    //    }
    //
    //}
    /**
     * 获取所有的套
     */
    //@PostMapping("/getAllSuit")
    //private ResultData getAllSuit(RequestASingleVo requestASingleVo){
    //    LoginGetDataService loginGetDataService = new LoginGetDataServiceImpl();
    //    //验证用户返回数据
    //    List<CourseintroductionTable> courseintroductionTables = loginGetDataService.selectAllSuitService(requestASingleVo);
    //    if(courseintroductionTables!=null){
    //        return new DefaultResultData(courseintroductionTables);
    //    }else{
    //        return new DefaultResultData(ResultCode.ERROR_BUSY_SERVER);
    //    }
    //}

    /**
     * 获取同一套所有视频
     */
    ////@PostMapping("/getASuit")
    //private ResultData getASuit(@RequestBody  RequestASingleVo requestASingleVo){
    //    List<VideoTable> videoTables = loginGetDataService.selectASuits(requestASingleVo);
    //    return new DefaultResultData(videoTables);
    //}


}
