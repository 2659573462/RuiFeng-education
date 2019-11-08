package com.rimi.ruiFeng.controller;

import com.rimi.ruiFeng.common.DefaultResultData;
import com.rimi.ruiFeng.common.ResultData;
import com.rimi.ruiFeng.util.FastDfsUtils;
import com.rimi.ruiFeng.util.FileUtils;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author chenjin
 * @date 2019/11/4 9:14
 */
@Api(tags = "上传图片")
@CrossOrigin
@RestController
public class FileUploadController {

    @PostMapping("/uploadFile")
    private ResultData uploadFile1(MultipartFile file, HttpServletRequest request){
        String fileName = null;
        //文件上传
        try {
            //fileName虚拟机的地址
             fileName = FastDfsUtils.upload(file.getBytes(), FileUtils.getFileSuffix(file.getOriginalFilename()));
            System.out.println(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new DefaultResultData(200,"成功");
    }

}
