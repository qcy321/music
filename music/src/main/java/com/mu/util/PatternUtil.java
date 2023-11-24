package com.mu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtil {

    public static String Exc(String content,String regExp)
    {
        Pattern compile = Pattern.compile(regExp);
        Matcher matcher = compile.matcher(content);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
        {
            if(matcher.group().equals(""))
                buffer.append(" ");
            else
                buffer.append(matcher.group());
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        /*String content = "I am noob from runoob";
        String pattern = "(?<=I).*(?=runoob)";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(content);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find())
        {
            if(matcher.group().equals(""))
                buffer.append(" ");
            else
                buffer.append(matcher.group());
        }
        System.out.println(buffer);*/
        String s = "外文名：Vae\n" +
                "\n" +
                "别名：嵩哥\n" +
                "\n" +
                "国籍：中国";
        System.out.println(PatternUtil.Exc(s, "(?<=外文名：)[\\s\\S]*(?=别名)")+"   你好呀");
    }
}
