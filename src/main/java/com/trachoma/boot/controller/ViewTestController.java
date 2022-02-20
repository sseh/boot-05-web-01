package com.trachoma.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author trachoma
 * @create 2022-02-20 18:43
 */
@Controller
public class ViewTestController {

    @GetMapping("/trachoma")
    public String trachoma(Model model) {
        model.addAttribute("msg", "你好，沙眼");
        model.addAttribute("link", "http://www.baidu.com");
        model.addAttribute("linkName", "沙眼");
        return "success";
    }
}
