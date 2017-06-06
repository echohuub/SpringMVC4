/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.web.ch4_5;

import com.hqb.springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by heqingbao on 2017/6/6.
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert", produces = {"application/x-heqingbao"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
