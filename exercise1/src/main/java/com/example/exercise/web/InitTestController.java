package com.example.exercise.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InitTestController {

    /**
     * 新建测试
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        return "test success";
    }

    /**
     * 集成Thymleaf测试
     * @param mv
     * @return
     */
    @RequestMapping(value = "/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/greeting");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }



}
