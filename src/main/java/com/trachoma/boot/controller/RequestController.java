package com.trachoma.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author trachoma
 * @create 2022-02-19 21:12
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {

        request.setAttribute("msg", "成功了...");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") String code,
                                       HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        map.put("req_msg", msg1);
        return map;
    }

}
