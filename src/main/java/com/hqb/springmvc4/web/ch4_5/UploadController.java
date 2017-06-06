/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by heqingbao on 2017/6/6.
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) { // 使用MultipartFile接收上传的文件
        try {
            File f = new File("/Users/heqingbao/Desktop/upload/" + file.getOriginalFilename());
            FileUtils.writeByteArrayToFile(f, file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
