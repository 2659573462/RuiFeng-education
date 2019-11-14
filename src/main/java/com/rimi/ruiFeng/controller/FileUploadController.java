package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultCode;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.mapper.UserTableMapper;
import com.rimi.ruiFeng.util.FastDfsUtils;
import com.rimi.ruiFeng.util.FileUtils;
import com.rimi.ruiFeng.util.UtilString;
import com.rimi.ruiFeng.vo.UpdateUserHeadVo;
import com.rimi.ruiFeng.vo.User;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传
 *
 * @author chenjin
 * @date 2019/11/4 9:14
 */
@Api(tags = "上传图片")
@CrossOrigin
@RestController
@Transactional(rollbackFor = Exception.class)
public class FileUploadController {

    @Resource
    private UserTableMapper userTableMapper;

    @PostMapping("/uploadFile")
    public ResultData uploadFile1(@RequestParam MultipartFile file, HttpServletRequest request){
        String fileName = null;
        //文件上传
        try {
            String originalFilename = file.getOriginalFilename();
            //fileName虚拟机的地址
            //List list=null;
            fileName = FastDfsUtils.upload(file.getBytes(), FileUtils.getFileSuffix(file.getOriginalFilename()));
            System.out.println(originalFilename+""+fileName);
            //list.add(originalFilename+"="+fileName);
            // list = demo05();
            //demo01(list);
            String s = originalFilename +"-----------------"+ fileName;
            if(fileName!=null){
                List f =new ArrayList();
                f.add(s);
                return  new DefaultResultData(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new DefaultResultData(ResultCode.FAIL);
    }

    @PostMapping("/uploadFileHead")
    public ResultData uploadFile2(@RequestBody String users, @RequestParam MultipartFile file, HttpServletRequest request){
              System.out.println(users);
              String[] strings1 = UtilString.InterceptString(users);
              List<String> strings = new ArrayList<>();
              String fileName = null;
              //文件上传
              try {
                 int i=0;
                  //fileName虚拟机的地址
                  fileName = FastDfsUtils.upload(file.getBytes(), FileUtils.getFileSuffix(file.getOriginalFilename()));
                  System.out.println(fileName);
                  if(fileName!=null){
                       i = userTableMapper.updateHead(strings1[0],fileName);
                   }
                  if(i>0){
                      ArrayList<String> strings2 = new ArrayList<>();
                      strings2.add(fileName);
                      return  new DefaultResultData(strings2);
                  }else {
                      return  new DefaultResultData(ResultCode.FAIL);
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
              return  new DefaultResultData(ResultCode.FAIL);
    }

    //private static void demo01(List<String> s) throws IOException {
    //    // 1. 创建文件夹
    //    File dir = new File("imgas");
    //    dir.mkdirs();
    //    // 2. 创建文件
    //    File stuFile = new File(dir, "user.txt");
    //    try {
    //        // 当同名文件已经存在，就会创建失败(就不会创建)
    //        boolean isok = stuFile.createNewFile();
    //    } catch (IOException e) {
    //        System.out.println("创建文件异常");
    //    }
    //    // 检查文件是否创建成功
    //    if (!stuFile.exists()) {
    //        System.out.println("文件没有创建成功");
    //    }
    //    // 写入信息
    //    FileWriter out = null;
    //    // 创建一个文件字符输出流
    //     out = new FileWriter("demo.txt");
    //    // 使用流对象写入数据到文件
    //    for (int i = 0; i < s.size(); i++) {
    //        out.write(s.get(i));
    //        // 系统的默认换行符
    //        out.write(System.lineSeparator());
    //        // 默认情况下，这个flush方法在执行close方法时会自动调用
    //        out.flush();
    //    }
    //    // 关闭流
    //    out.close();
    //    System.out.println("数据保存成功");
    //}
    //
    //
    //private static List demo05() {
    //    // 先清空内存中集合数据
    //    List<String> users = null;
    //    users.clear();
    //    // 缓冲字符流
    //    BufferedReader buffIn = null;
    //    try {
    //        FileReader in = new FileReader("user.txt");
    //        buffIn = new BufferedReader(in);
    //        // 读取数据
    //        String res = null;
    //        while ((res = buffIn.readLine()) != null) {
    //            // 对获取的每一行数据进行处理
    //            String[] strs = res.split("=");
    //            String s = strs.toString();
    //            users.add(s);
    //        }
    //        System.out.println("读取文件成功");
    //        return users;
    //    } catch (FileNotFoundException e) {
    //        e.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }finally {
    //        try {
    //            if (buffIn != null) {
    //                buffIn.close();
    //            }
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //    }
    //
    //    return users;
    //}




}
