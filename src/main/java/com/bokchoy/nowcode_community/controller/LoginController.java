package com.bokchoy.nowcode_community.controller;

import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.service.UserService;
import com.bokchoy.nowcode_community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

/**
 * @author bokchoy
 * @description: 登录，注册
 * @date 2021年10月26日 13:14
 */
@Controller
public class LoginController implements CommunityConstant {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterPage(){
        return "/site/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model, User user){
        HashMap<String,Object> map=userService.register(user);
        if (map==null||map.isEmpty()){
            //注册成功
            model.addAttribute("msg","注册成功,我们已经发送一封激活邮件，请尽快激活！");
            model.addAttribute("target","index");
            return "/site/operate-result";
        }else {
            model.addAttribute("usernameMessage",map.get("usernameMessage"));
            model.addAttribute("passwordMessage",map.get("passwordMessage"));
            model.addAttribute("emailMessage",map.get("emailMessage"));
            return "/site/register";
        }

    }

    @RequestMapping(value = "/activation/{id}/{code}",method = RequestMethod.GET)
    public String activation(Model model, @PathVariable(name = "id") Integer id,
                             @PathVariable(name = "code") String code){
        int activation = userService.activation(id, code);
        if (activation==ACTIVATION_SUCCESS){
            model.addAttribute("msg","激活成功！");
            model.addAttribute("target","/login");

        }else if (activation==ACTIVATION_FAilURE){
            model.addAttribute("msg","激活失败！");
            model.addAttribute("target","/index");
        }else {
            model.addAttribute("msg","重复激活！");
            model.addAttribute("target","/login");
        }
        return "/site/operate-result";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginPage(){
        return "/site/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model){

        return "/index";
    }
}
