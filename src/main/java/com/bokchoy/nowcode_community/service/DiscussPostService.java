package com.bokchoy.nowcode_community.service;

import com.bokchoy.nowcode_community.entity.DiscussPost;
import com.bokchoy.nowcode_community.mapper.DiscussPostExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bokchoy
 * @description:
 * @date 2021年10月20日 15:16
 */
@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostExtMapper discussPostExtMapper;

    public List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit){
        return discussPostExtMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int selectDiscussPostRows(int userId){
        return discussPostExtMapper.selectDiscussPostRows(userId);
    }
}
