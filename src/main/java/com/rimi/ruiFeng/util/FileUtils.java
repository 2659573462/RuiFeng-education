package com.rimi.ruiFeng.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author chenjin
 * @date 2019/11/4 9:20
 */
public class FileUtils {

    private static final String FILE_PATH = "/resources/file/";


    /**
     * @param request
     * @param file
     * @return
     */
    public static String uploadFile( MultipartFile file ,HttpServletRequest request) {
        String fileName = null;
        if (file != null) {
            try {
                String tealPath = getTealPath(request);
                System.out.println(tealPath);
                createFIleDiirectory(tealPath);
                 fileName = getNewFileName(file);
                 //File.separator 代表斜杠
                file.transferTo(new File(tealPath + File.separator + fileName));
                return FILE_PATH + fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public static String getNewFileName(MultipartFile file) {
        //重写命名
        String fileName = System.currentTimeMillis() + "" ;

        //获取文件的后缀
        String suffix = getFileSuffix(file.getOriginalFilename());

        return fileName + "." + suffix;
    }


    /**
     * 判断虚拟目录的文件是否存在
     * @param realPath :文件地址
     */
    public static void createFIleDiirectory(String realPath) {
        //判断文件是否存在
        File filePath = new File(realPath);
        //isDirectory : 这是判断抽象路径目录是否存在
        if(!(filePath.isDirectory()&&filePath.exists())){
            //创建此抽象路径的文件
            filePath.mkdirs();
        }
    }

    /**
     * 获取服务器启动的地址
     * @param request
     * @return
     */
    public static String getTealPath(HttpServletRequest request) {
        //获取文件位置
        return request.getServletContext().getRealPath(FILE_PATH);
    }

    /**
     *
     * @param originalFilename
     * @return
     */
    public static String getFileSuffix(String originalFilename) {
        // 获取文件的后缀   xx.png
        int index = originalFilename.lastIndexOf(".");
        return originalFilename.substring(index + 1);
    }
}
