package com.itqf.untils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * 隔壁老王在练腰，你的情人在磨刀，
 * 加油 , 望有朝一日，走路生风，跨步起云，踏浪无痕。
 */
public class FastDFSUtils {
    //第一步 声明出  传递图片需要的核心对象 tracker storage
            TrackerClient trackerClient=null; // 跟踪器的客户端
            TrackerServer trackerServer=null;  //更重服务器的服务端
            StorageServer storageServer=null; // 存储服务器的服务端
            StorageClient storageClient=null;// 存储服务器的客户端
    public FastDFSUtils(){
            try {
                // 第二步   加载配置文件  client.conf
                ClientGlobal.init("client.conf");
                System.out.println(ClientGlobal.configInfo());  // 测试是否拿到了配置文件内的信息
                // 第三步 创建tracker对象    原理 先有tracker创建的跟踪器查看有没有对应的服务  有的话返回服务的ip等信息
                // 然后在由 storage 进行图片的上传下载
                trackerClient= new TrackerClient();
                // 得到trackerserver对象
                trackerServer =trackerClient.getConnection();
                // 4 构建storageClient对象
                storageClient=new StorageClient(trackerServer,storageServer);// 将跟踪的服务器和上传下载的服务器传递到
                //   上传下载的客户端内
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }
    }
    // 写上传文件的工具类
    public String[] upload(String local_name,String suffix){
            try {
                return storageClient.upload_file(local_name,suffix,null);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }
            return null;
    }
    // 方法重载
    public String[] upload(byte [] b,String ext){
        try {
            return  storageClient.upload_file(b,ext,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
         return  null;
    }



}
