/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4.domain;

/**
 * Created by heqingbao on 2017/6/6.
 */
public class DemoObj {

    private Long id;
    private String name;

    public DemoObj() {
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
