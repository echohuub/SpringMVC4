/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_3;

import com.hqb.springmvc4.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by heqingbao on 2017/6/6.
 */
@RestController // 使用@RestController，声明是控制器，并且返回数据时不需要@RequestBody
@RequestMapping("/reset")
public class DemoRestController {

    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8") // 返回数据的媒体类型为json
    public DemoObj getJson(DemoObj obj) {
        return new DemoObj(obj.getId(), obj.getName() + "yy"); // 直接返回对象，对象会自动转换成json
    }

    @RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8") // 返回数据的媒体类型为xml
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId(), obj.getName() + "yy"); // 直接返回对象，对象会自动转换成xml
    }
}
