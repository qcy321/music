package com.mu.controller;

import com.mu.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseResult
@RestController
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
