package com.bokchoy.nowcode_community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author bokchoy
 * @description: 日志测试
 * @date 2021年10月24日 20:48
 */

@SpringBootTest
//定义配置文件
@ContextConfiguration(classes = NowcodeCommunityApplication.class)
//@MapperScan(basePackages = "com.bokchoy.nowcode_community.mapper")
public class LoggerTest {
    //选择slf4j包
    private static final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debug logger");
        logger.info("info logger");
        logger.warn("warn logger");
        logger.error("error logger");

    }
}
