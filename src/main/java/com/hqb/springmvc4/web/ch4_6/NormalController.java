/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_6;

import com.hqb.springmvc4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by heqingbao on 2017/6/7.
 */
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/normal")
    public String normal(Model model) {
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }
}
