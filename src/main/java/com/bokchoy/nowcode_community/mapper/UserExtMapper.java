package com.bokchoy.nowcode_community.mapper;

import com.bokchoy.nowcode_community.entity.User;

public interface UserExtMapper {

    public int insertUser(User user);

    public User selectById(int id);

}
