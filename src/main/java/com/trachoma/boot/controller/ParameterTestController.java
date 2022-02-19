package com.trachoma.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author trachoma
 * @create 2022-02-19 20:40
 */
@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("hobby") List<String> hobby,
                                      @RequestParam Map<String, String> param) {

        Map<String, Object> hashMap = new HashMap<>();

//        hashMap.put("id", id);
//        hashMap.put("username", username);
//        hashMap.put("map", pv);
//        hashMap.put("userAgent", userAgent);
//        hashMap.put("header", header);
        hashMap.put("age", age);
        hashMap.put("hobby", hobby);
        hashMap.put("param", param);
        return hashMap;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {

        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("content", content);
        return hashMap;
    }

    //cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand,
                                        @PathVariable("path") String path) {

        Map<String, Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    //boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") String bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") String empAge) {

        Map<String, Object> map = new HashMap<>();

        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }
}
