package com.mu.controller;

import com.mu.annotation.ResponseResult;
import com.mu.entities.Singer;
import com.mu.entities.User;
import com.mu.responseUtil.R;
import com.mu.util.MyTimeUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@ResponseResult
public class TestController {

    @RequestMapping("/hello")
    public R getWorld() {
        return R.ok().data("hello world");
    }

    @RequestMapping("/localDateTime")
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    @RequestMapping("/localDate")
    public LocalDate localDate() {
        return LocalDate.now();
    }

    @RequestMapping("/localTime")
    public LocalTime localTime() {
        return LocalTime.now();
    }

    @RequestMapping("/test")
    public LocalDateTime test(LocalDateTime l) {
        return l;
    }

    @RequestMapping("/test1")
    public long test1() {
        return 1000000;
    }

    @RequestMapping("/ff")
    public Ff ff() {
        return new Ff(new Date(), LocalDateTime.now(), LocalDate.now(), System.currentTimeMillis());
    }

    @RequestMapping("/d")
    public Date d(Date date, LocalDateTime ldt, LocalDate ld, LocalTime lt) {
        System.out.println(date);
        System.out.println(ldt);
        System.out.println(ld);
        System.out.println(lt);
        return date;
    }

    @RequestMapping("/long")
    public Long timeMill() {
        return System.currentTimeMillis();
    }

    @RequestMapping("/s")
    public String timeMill(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/u")
    public User u(User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/id")
    public Map<String, Object> getId(@RequestParam(name = "id", required = false) Integer id, int f) {
        Map<String, Object> map = new HashMap<>();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUsername("张三" + i);
            user.setId(1000 + i);
            list.add(user);
        }
        List<Singer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Singer singer = new Singer();
            singer.setSingerId(1);
            singer.setName("周杰伦");
            singer.setDateOfBirth(new Date());
            list1.add(singer);
        }

        map.put("users", list);
        map.put("singers", list1);
        return map;
    }

    public static long s(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    @Data
    @AllArgsConstructor
    class Ff {
        Date d;

        LocalDateTime ld;

        LocalDate l;

        long time;
    }


    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(6, 12, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200));
        /*for (int i = 0; i < 20; i++) {
            int j = i;
            threadPoolExecutor.execute(() -> {
                //System.out.println(simpleDateFormat.format(new Date(1000 * j))+"pp");
                System.out.println(MyTimeUtil.dateTimeToLong(1000 * j).format(dateTimeFormatter)+"ll");
            });
        }*/
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            //System.out.println(MyTimeUtil.dateTimeToLong(1000 * i).format(dateTimeFormatter)+"ll");
            //simpleDateFormat.format(new Date(1000 * i));
            MyTimeUtil.dateTimeToLong(1000 * i).format(dateTimeFormatter);
        }
        System.out.println(System.currentTimeMillis() - l);
        //threadPoolExecutor.shutdown();
    }

}
