package com.street.conteoller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: OldStreetHong
 * @date: 2021/7/27 11:24
 * @desc:
 */
@RestController
@RequestMapping("/img")
public class ImgController {
    //接收图片
    @RequestMapping("/upload/{phoneNumber}")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file,@PathVariable("phoneNumber") String phoneNumber) throws IOException {
        System.err.println(phoneNumber);
        System.out.println(System.getProperty("user.dir") + "/upload");
        Map<String, Object> map = new HashMap<>();
        if (file != null) {  //如果获取到的文件不为空
            String filename = file.getOriginalFilename();
            // 上传文件存储目录 //获取当前的路径
            String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/upload/" + phoneNumber +"/";
            String pathname = UPLOAD_DIRECTORY;
            File file_server = new File(pathname, filename);  //创建文件对象
            if (!file_server.getParentFile().exists()) {
                //如果文件父目录不存在，就创建这样一个目录
                file_server.getParentFile().mkdirs();
                System.out.println("创建目录" + file);
            } else {  //如果父文件夹已经存在

            }
            file.transferTo(file_server);
            map.put("status", true);
            map.put("msg", "上传文件成功");
        } else {   //如果获取到的文件为空
            map.put("status", false);
            map.put("msg", "上传文件失败");
            map.put("reason", "文件为空");
        }
        return map;
    }


}
