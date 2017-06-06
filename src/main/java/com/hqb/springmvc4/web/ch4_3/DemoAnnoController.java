/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_3;

import com.hqb.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by heqingbao on 2017/6/6.
 */
@Controller
@RequestMapping("/anno") // 映射此类的访问路径是/anno
public class DemoAnnoController {

    // 1.此方法未标注路径，因此使用类级别的路径/anno
    // 2.produces可定制返回的response的媒体类型和字符集，如需返回值是json对象，则设置produces="application/json;charset=UTF-8"
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) { // 可接受HttpServletRequest作为能数
        return "url:" + request.getRequestURL() + " can access";
    }

    // 接受路径参数，并在方法参数前结合@PathVariable使用，访问路径为/anno/pathvar/xx
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access, str: " + str;
    }

    // 常规的request参数获取，访问路径为/anno/requestParam?id=1
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access, id: " + id;
    }

    // 解释参数到对象，访问路径为/anno/obj?id=1&name=xx
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody // @ResponseBodys可以用在方法上
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url: " + request.getRequestURL() + " can access, obj id: " + obj.getId() + " obj name: " + obj.getName();
    }

    // 映射不同路径到相同的方法，访问路径为/anno/name1或/anno/name2
    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {
        return "url: " + request.getRequestURI() + " can access";
    }

}
