/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_4;

import com.hqb.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by heqingbao on 2017/6/6.
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModeAttribute:" + msg);
    }
}
