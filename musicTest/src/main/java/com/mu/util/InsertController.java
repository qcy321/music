package com.mu.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("in")
public class InsertController {

    @RequestMapping("insert")
    public String insert(){
        ReadFileContent readFileContent = new ReadFileContent();
        //readFileContent.getFile("D:\\音乐");
        return "";
    }
}
