package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.ShopTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.common.*;
import com.rimi.ruiFeng.service.CourseintroductionTableService;
import com.rimi.ruiFeng.service.InsertShoppingService;
import com.rimi.ruiFeng.service.OrdeTableService;
import com.rimi.ruiFeng.service.UserTableService;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.SoppingVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车控制层
 *
 * @author chenjin
 * @date 2019/11/12 16:16
 */
@Api(tags = "购物车控制层")
@CrossOrigin
@RestController
public class ShoppingTrolleyController {

    @Autowired
    private UserTableService userTableService;

    @Autowired
    private CourseintroductionTableService courseintroductionTableService;

    @Autowired
    private InsertShoppingService insertShoppingService;


    @Autowired
    private OrdeTableService OrdeTableService;


    /**
     * 加入购物车
     * @param soppingVo
     * @return
     */
    @PostMapping("/insertSoppings")
    private Result insertSoppings(@RequestBody  SoppingVo soppingVo){
        System.out.println(soppingVo);

        int i = insertShoppingService.insertSoppings(soppingVo);
        System.out.println(i);
        if(i==-10){
            return new DefaultResult(ResultCode.PRODUCT_DOES_NOT_EXIST);
        }
        if(i==-5||i==0){
            //说明用户已经购买
            if(i==0){
                return new DefaultResult(ResultCode.FAIL);
            }
            return new DefaultResult(ResultCode.HAVE_ALREADY_PURCHASED);
        }else{
            return new DefaultResult(ResultCode.SUCCESS);
        }
    }

    /**
     * 获取购物车数据
     *
     */
    @PostMapping("/getUserSopping")
    private ResultData getUserSopping(@RequestBody  SoppingVo soppingVo){
        System.out.println(soppingVo);
        System.out.println(soppingVo.getVerification());
        ShopTable shopTable = insertShoppingService.selectUsername(soppingVo.getVerification());
        List<CourseintroductionTable> count=new ArrayList<>();
        if(shopTable.getShopcartOrderid()==null){
            return new DefaultResultData(ResultCode.NOT_NOSOPPING);
        }else{
            String[] strings = UtilString.InterceptString(shopTable.getShopcartOrderid());
            for (int i = 0; i <strings.length ; i++) {
                CourseintroductionTable courseintroductionTable = courseintroductionTableService.selectDistinction(strings[i]);
                if(courseintroductionTable!=null){
                    count.add(courseintroductionTable);
                }
            }
        }
        return new DefaultResultData(count);
    }

    /**
     * 删除购物车
     * 删除发送的是数组
     */
    @PostMapping("/deleteByOrderid")
    private ResultData deleteByOrderid(@RequestBody  SoppingVo soppingVo){
        System.out.println(soppingVo);
        System.out.println("前端发送修改购物车的参数"+soppingVo.getCommoditys());
        int i =  insertShoppingService.deleteByOrderid(soppingVo);
        if(i==-5){
            //意思是当前用户还没有购买商品
            return new DefaultResultData(ResultCode.NOT_NOSOPPINGS);
        }else if(i==1){
            return new DefaultResultData(ResultCode.SUCCESS);
        }else{
            return new DefaultResultData(ResultCode.FAIL);
        }
    }


    /**
     * 加入支付状态生成订单
     */
    @PostMapping("/readyToPay")
    private ResultData readyToPay(@RequestBody SoppingVo soppingVo){
        System.out.println(soppingVo);
        System.out.println("前端发送修改购物车的参数"+soppingVo.getCommoditysSopping());
       if(soppingVo.getCommoditysSopping()==null || soppingVo.getVerification()==null){
           return new DefaultResultData(ResultCode.ERROR_PARAMETER);
       }
       //传入的用户想预支付的套
        String[] commoditysSopping = soppingVo.getCommoditysSopping();
        String verification = soppingVo.getVerification();
        //用户名拆解
        String[] strings = UtilString.InterceptString(verification);
        UserTable userTable = userTableService.selectUsername(strings[0]);
        //判断用户查找的用户不能为空
        if(userTable==null){
            return new DefaultResultData(ResultCode.INEXISTENCE);
        }
        //用户已经拥有的视频
        String userByvideo = userTable.getUserByvideo();
        String[] strings1 = UtilString.InterceptString(userByvideo);


        //遍历查询当前要生成的订单用户是否拥有
        for (int i = 0; i <strings1.length ; i++) {
            for (int j = 0; j <commoditysSopping.length ; j++) {
                if(strings1[0].equals(commoditysSopping[j])){
                    //当前商品已经存在
                    return new DefaultResultData(ResultCode.DESCRIPTION,"当前商品已经存在:"+strings1[0]);
                }
            }
        }

        //判断用户订单是否已经生成过 :或者说是需要购买的订单已经生成
        //OrdeTable userOrde = OrdeTableServiceImpl.selectUsername(strings[0]);

        List<CourseintroductionTable> acs = new ArrayList<CourseintroductionTable>();
        for (int i = 0; i <commoditysSopping.length ; i++) {
            CourseintroductionTable courseintroductionTable1 = courseintroductionTableService.selectDistinction(commoditysSopping[i]);
            if(courseintroductionTable1!=null){
                acs.add(courseintroductionTable1);
            }
        }


        return  new DefaultResultData(acs);
    }

    public static void main(String[] args) {
        String s= ",,123,5154";
        String[] strings = UtilString.InterceptString(s);
        for (int i = 0; i <strings.length ; i++) {
            System.out.println(strings[i]);
        }
    }

}
