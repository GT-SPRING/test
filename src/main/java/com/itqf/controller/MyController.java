package com.itqf.controller;

import com.itqf.untils.FastDFSUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 隔壁老王在练腰，你的情人在磨刀，
 * 加油 , 望有朝一日，走路生风，跨步起云，踏浪无痕。
 */
// 使用自定义的工具类 完成图片的上传
@Controller
public class MyController {
    @RequestMapping("upload.json")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file){// MultipartFile
        try {
            /// @RequestParam("file")MultipartFile file 接受文件类型时后端的写法
            // 第一步 得到文件的名称
            String name =file.getOriginalFilename();
            // 2 后缀 substring截取 参数为角标  lastIndexOf最后一次出现字符的时候的角标 不包含所以+1
            String  suffix = name.substring(name.lastIndexOf(".") + 1);// 截取字符串
            byte[] fileBytes = file.getBytes();
            FastDFSUtils dfsUtils = new FastDFSUtils();
            String[] strings = dfsUtils.upload(fileBytes, suffix);// 文件字节流 和截取的文件字符后缀
            StringBuilder stringBuilder=new StringBuilder("http://10.9.29.33:82/");
            if (strings!=null){
                for (int i=0;i<strings.length;i++) {
                    stringBuilder.append(strings[i]); // 追加
                    if(i==0){
                        stringBuilder.append("/");
                    }
                    System.out.println("++++++++++++");
                    System.out.println(strings[i]);
                }
            }//返回结果http://10.9.29.33:82/group1/M00/00/00/CgkdIV02zQGARhu3AAqibK2Dz6I330.jpg
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @RequestMapping("/fileupload.json")
    @ResponseBody
    public Map<String,Object> fileupload(@RequestParam("file")MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        try {
            /// @RequestParam("file")MultipartFile file 接受文件类型时后端的写法
            // 第一步 得到文件的名称
            String name =file.getOriginalFilename();
            // 2 后缀 substring截取 参数为角标  lastIndexOf最后一次出现字符的时候的角标 不包含所以+1
            String  suffix = name.substring(name.lastIndexOf(".") + 1);// 截取字符串
            byte[] fileBytes = file.getBytes();
            FastDFSUtils dfsUtils = new FastDFSUtils();
            String[] strings = dfsUtils.upload(fileBytes, suffix);// 文件字节流 和截取的文件字符后缀
            StringBuilder stringBuilder=new StringBuilder("http://10.9.29.33:82/");
            if (strings!=null){
                for (int i=0;i<strings.length;i++) {
                    stringBuilder.append(strings[i]); // 追加
                    if(i==0){
                        stringBuilder.append("/");
                    }
                    System.out.println("++++++++++++");
                    System.out.println(strings[i]);
                }
            }//返回结果http://10.9.29.33:82/group1/M00/00/00/CgkdIV02zQGARhu3AAqibK2Dz6I330.jpg
            String url=stringBuilder.toString();
            map.put("status",200);
            map.put("msg","success");
            map.put("url",url);
            return map;

        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("status",500);
        map.put("msg","shibai");
        return map;
        }
 }
