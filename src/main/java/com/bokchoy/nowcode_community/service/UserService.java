package com.bokchoy.nowcode_community.service;

import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bokchoy
 * @description:
 * @date 2021年10月20日 15:20
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User selectUserById(String id){
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }
}
