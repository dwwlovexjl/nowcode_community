package com.bokchoy.nowcode_community.service;

import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.entity.UserExample;
import com.bokchoy.nowcode_community.mapper.UserMapper;
import com.bokchoy.nowcode_community.util.CommunityConstant;
import com.bokchoy.nowcode_community.util.CommunityUtil;
import com.bokchoy.nowcode_community.util.MailClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author bokchoy
 * @description:
 * @date 2021年10月20日 15:20
 */
@Service
public class UserService implements CommunityConstant {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;//模板解析引擎

    @Value("${nowcode_community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public User selectUserById(String id){
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

    public HashMap<String, Object> register(User user) {
        HashMap<String, Object> map = new HashMap<>();
        if (user==null){
            throw new IllegalArgumentException("user不能为空");
        }
        //判断字段是否为空
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("usernameMessage","用户名不能为空!");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("passwordMassage","密码不能为空!");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("emailMassage","邮箱不能为空!");
            return map;
        }
        //验证账号是否存在
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> findUserByUsername = userMapper.selectByExample(userExample);
        if (findUserByUsername!=null&&findUserByUsername.size()!=0){
            map.put("usernameMessage","用户名已存在!");
            return map;
        }
        userExample.clear();
        userExample.createCriteria().andEmailEqualTo(user.getEmail());
        List<User> findUserByEmail = userMapper.selectByExample(userExample);
        if (findUserByEmail!=null&&findUserByEmail.size()!=0){
            map.put("emailMessage","该邮箱已注册!");
            return map;
        }

        //注册用户
        String uuid = CommunityUtil.generateUUID();
        user.setSalt(uuid.substring(0,5));//设置随机数
        user.setPassword(CommunityUtil.md5(user.getPassword()+user.getSalt()));
        user.setActivationCode(CommunityUtil.generateUUID());//设置激活码
        user.setHeaderUrl(String.format("https://images.nowcoder.com/head/%dt.png",
                new Random().nextInt(1000)));//设置随机头像
        user.setCreateTime(new Date());
        user.setType(0);
        user.setStatus(0);
        userMapper.insert(user);

        //发送验证邮件
        //http://www.nowcoder.com/community/activation/123/code
        String url=domain+contextPath+"/activation/"+user.getId()+"/"+user.getActivationCode();
        Context context = new Context();//选用thymeleaf的context
        context.setVariable("username",user.getEmail());
        context.setVariable("url",url);
        String content = templateEngine.process("/mail/activation", context);
        mailClient.sendMail(user.getEmail(),"激活账号",content);
        return map;
    }

    public int activation(int id, String code) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user.getStatus()==1){
            return ACTIVATION_REPEAT;
        }else if (user.getActivationCode().equals(code)) {
            user.setStatus(1);
            userMapper.updateByPrimaryKeySelective(user);
            return ACTIVATION_SUCCESS;
        }else {
            return ACTIVATION_FAilURE;
        }
    }
}
