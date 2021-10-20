package com.bokchoy.nowcode_community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan(basePackages = "com.bokchoy.nowcode_community.mapper")
public class NowcodeCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(NowcodeCommunityApplication.class, args);
	}

}
