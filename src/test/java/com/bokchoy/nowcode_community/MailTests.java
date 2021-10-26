package com.bokchoy.nowcode_community;

import com.bokchoy.nowcode_community.util.MailClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author bokchoy
 * @description: 发送邮件测试类
 * @date 2021年10月25日 20:08
 */
@SpringBootTest
//定义配置文件
@ContextConfiguration(classes = NowcodeCommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;



    @Test
    public void testTextMail(){
        mailClient.sendMail("15855459380@163.com","Test Text","welcome");
    }

    @Autowired
    private TemplateEngine templateEngine;//模板引擎

    @Test
    public void testHtmlMail(){
        Context context = new Context();//选用Thymeleaf
        context.setVariable("username","bokchoy");//页面上就可以调用到
        //利用模板引擎编译页面模板
        String content = templateEngine.process("/mail/activation", context);
        System.out.println(content);
        mailClient.sendMail("15855459380@163.com","Test Text",content);
    }

}
