package com.rimi.ruiFeng.util;


import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import java.io.IOException;

/**
 * @author chenjin
 * @date 2019/11/4 9:18
 */
public class FastDfsUtils {
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient1 storageClient1;


    static{
        try {
            ClientGlobal.initByProperties("config/db/fastdfs-client.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient1 = new StorageClient1(trackerServer, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }


    public  static String upload(byte[] fileBytes, String suffix){
        StorageClient1 client1 = new StorageClient1();
        //System.out.println(fileBytes);
        try {
            //fileBytes:文件的绝对地址
            return storageClient1.upload_file1(fileBytes, suffix, null);        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static String uploadLocalFile(String file , String suffix){
        StorageClient1 client1 = new StorageClient1();
        try {
            return storageClient1.upload_file1(file, suffix, null);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
