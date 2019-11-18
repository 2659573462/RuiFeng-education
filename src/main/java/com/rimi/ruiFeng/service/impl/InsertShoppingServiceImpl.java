package com.rimi.ruiFeng.service.impl;

import com.rimi.ruiFeng.bean.CourseintroductionTable;
import com.rimi.ruiFeng.bean.ShopTable;
import com.rimi.ruiFeng.bean.UserTable;
import com.rimi.ruiFeng.mapper.CourseintroductionTableMapper;
import com.rimi.ruiFeng.mapper.ShopTableMapper;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.service.InsertShoppingService;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.util.VerificationLogin;
import com.rimi.ruiFeng.vo.SoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenjin
 * @date 2019/11/12 16:49
 */
@Service
public class InsertShoppingServiceImpl implements InsertShoppingService {

    @Resource
    private UserTableMapper userTableMapper;

    @Autowired
    private CourseintroductionTableMapper courseintroductionTableMapper;

    @Autowired
    private ShopTableMapper shopTableMapper;

    /**
     * 将商品加入用户的购物车
     *
     * @param soppingVo
     * @return
     */
    @Override
    public int insertSoppings(SoppingVo soppingVo) {
        int is = 0;
        String statusode = soppingVo.getVerification();
        System.out.println(statusode);
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(statusode);
        if(verifcation){
            //用户打算加入购物车的商品
            String commoditys = soppingVo.getCommoditys();
            //UrO5VIDsYf0P7S70k9zPP7ZkHf3sXxM+fZqIaxjEWPg=, XN6zUlSsYacA1crhS2D/Km6/Px9cMkoAqdPu + VPX00s=
            //UrO5VIDsYf0P7S70k9zPP7ZkHf3sXxM+fZqIaxjEWPg=, XN6zUlSsYacA1crhS2D/Km6/Px9cMkoAqdPu + VPX00s=
            //UrO5VIDsYf0P7S70k9zPP7ZkHf3sXxM+fZqIaxjEWPg=,emC++5fhKzco+mQTGqOa7Bi+X/UNO5iCP5GCj1rB3ts=
            CourseintroductionTable courseintroductionTable = courseintroductionTableMapper.selectDistinction(commoditys);
            if(courseintroductionTable==null){
                return -10;
            }

            String[] strings1 = UtilString.InterceptString(statusode);
            UserTable userTable = userTableMapper.selectUsername(strings1[0]);

            //购物车id
            String userByvideo = userTable.getUserShopcart();
            System.out.println("用户购物车"+userByvideo);
            //查询购物车
            ShopTable shopTable = shopTableMapper.selectByPrimaryKey(Integer.valueOf(userByvideo));

            //用户已购买
            String[] strings2 = UtilString.InterceptString(shopTable.getShopcartOrderid());
            for (int i = 0; i <strings2.length ; i++) {

                System.out.println("用户已经购买"+strings2[i]);
            }
            //查看用户的已购买
            for (int i = 0; i <strings2.length ; i++) {
                boolean equals = strings2[i].equals(commoditys);
                if(equals){
                   is=-5;
                   break;
                }
            }
            //查询用户的

            if(is==-5){
                return is;
            }else{
                String shopcartOrderid = shopTable.getShopcartOrderid();
                shopcartOrderid =shopcartOrderid + ","+commoditys;
                System.out.println(shopcartOrderid);
                System.out.println(strings1[0]);
                int e = shopTableMapper.updateOrderid(strings1[0],shopcartOrderid);
                return e;
            }

        }else{

            return is;
        }
    }

    /**
     * 查询用户的购物车
     * @param userName
     * @return
     */
    @Override
    public ShopTable selectUsername(String userName) {
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(userName);
        if(verifcation){
            String[] strings = UtilString.InterceptString(userName);
            ShopTable shoppingUser = shopTableMapper.selectUserName(strings[0]);
            return shoppingUser;
        }else{
            return null;
        }
    }
    /**
     * 删除购物车中选中的
     */
    @Override
    public int deleteByOrderid(SoppingVo soppingVo) {
        String statusode = soppingVo.getVerification();
        Boolean verifcation = new VerificationLogin(userTableMapper).getVerifcation(statusode);
        //想删除的商品
        String[] strings = soppingVo.getCommoditysSopping();
        //用户对象
        String[] strings3 = UtilString.InterceptString(statusode);
        //查询用户的购物车
        ShopTable shopTable = shopTableMapper.selectUserName(strings3[0]);
        System.out.println(shopTable.getShopcartOrderid());
        String shopcartOrderid = shopTable.getShopcartOrderid();
        System.out.println("修改前的字符串"+shopcartOrderid);
        if(shopcartOrderid==null){
            return -5;
        }
        //用户的商品
        String[] strings1 = UtilString.InterceptString(shopcartOrderid);
        for (int i = 0; i <strings.length ; i++) {
            for (int j = 0; j <strings1.length ; j++) {
                if(strings1[j].equals(strings[i])){
                    strings1[j]="";
                }
            }
        }

        //生成新的字符串
        String stringOrderid="";
        for (int i = 0; i <strings1.length ; i++) {
            stringOrderid= stringOrderid+strings1[i];
            if(strings1.length-i>1){
                stringOrderid=stringOrderid+",";
            }
        }
        //修改删除后的字符串
        System.out.println("修改后的字符串"+stringOrderid);

        int i = shopTableMapper.updateOrderid(strings3[0], stringOrderid);
        return i;
    }



}
