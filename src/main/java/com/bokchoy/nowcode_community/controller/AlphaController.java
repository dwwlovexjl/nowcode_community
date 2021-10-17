package com.bokchoy.nowcode_community.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bokchoy
 * @description: 学习测试控制类
 * @date 2021年10月16日 15:25
 */
@Controller
@RequestMapping("/alpha")//加在类上，类里面所有函数都是该路径的子路径
public class AlphaController {
    @RequestMapping("hello")
    @ResponseBody//返回json数据
    public String sayHello(){
        return "hello";
    }

    //响应JSON数据(异步请求)：
    // Java对象 -> JSON字符串 -> JS对象,使用@ResponseBody注解
    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "张三");
        emp.put("age", 23);
        return emp;
    }//转换为json字符串  {"name":"张三","age":"23"}
    //也可以返回List<Map<String, Object>>，list集合。

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());//获取请求方式
        System.out.println(request.getServletPath());//获取请求路径
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+ ":" +value);
        }
        System.out.println(request.getParameter("code"));//获取请求体数据

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try(PrintWriter writer = response.getWriter()) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(//@RequestParam获取请求的数据
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        //@PathVariable获取数据，获取的是{id}"里面的数据
        System.out.println(id);
        return "a student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        //参数会自动匹配，根据参数名匹配
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //通过ModelAndView构造返回页面
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "张三");
        mav.addObject("age", 30);
        mav.setViewName("/demo/view");//传入templates/demo/view.html
        return mav;
    }

    //通过model域交互数据
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", 80);
        return "/demo/view";
    }
}
