package com.bokchoy.nowcode_community.controller;

import com.bokchoy.nowcode_community.dto.DiscussPostDTO;
import com.bokchoy.nowcode_community.dto.Page;
import com.bokchoy.nowcode_community.entity.DiscussPost;
import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.service.DiscussPostService;
import com.bokchoy.nowcode_community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bokchoy
 * @description: 主页
 * @date 2021年10月20日 15:33
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        int userId=0;
        int rows = discussPostService.selectDiscussPostRows(userId);
        page.setRows(rows);
        page.setPath("/index");
        LinkedList<HashMap<String, Object>> list = new LinkedList<>();
        List<DiscussPost> discussPosts = discussPostService.selectDiscussPosts(userId, page.getOffset(), page.getLimit());
        for (DiscussPost discussPost : discussPosts) {
            User user = userService.selectUserById(discussPost.getUserId());
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("user",user);
            stringObjectHashMap.put("discussPost",discussPost);
            list.addLast(stringObjectHashMap);
        }
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "index";
    }*/

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        int userId=0;
        int rows = discussPostService.selectDiscussPostRows(userId);
        page.setRows(rows);
        page.setPath("/index");
        LinkedList<DiscussPostDTO> list = new LinkedList<>();
        List<DiscussPost> discussPosts = discussPostService.selectDiscussPosts(userId, page.getOffset(), page.getLimit());
        for (DiscussPost discussPost : discussPosts) {
            User user = userService.selectUserById(discussPost.getUserId());
            DiscussPostDTO discussPostDTO = new DiscussPostDTO();
            discussPostDTO.setUser(user);
            discussPostDTO.setDiscussPost(discussPost);
            list.addLast(discussPostDTO);
        }
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        return "index";
    }
}
