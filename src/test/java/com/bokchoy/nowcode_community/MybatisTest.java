package com.bokchoy.nowcode_community;

import com.bokchoy.nowcode_community.entity.DiscussPost;
import com.bokchoy.nowcode_community.entity.DiscussPostExample;
import com.bokchoy.nowcode_community.entity.User;
import com.bokchoy.nowcode_community.entity.UserExample;
import com.bokchoy.nowcode_community.mapper.DiscussPostExtMapper;
import com.bokchoy.nowcode_community.mapper.DiscussPostMapper;
import com.bokchoy.nowcode_community.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @author bokchoy
 * @description:
 * @date 2021年10月17日 19:47
 */

@SpringBootTest
@ContextConfiguration(classes = NowcodeCommunityApplication.class)

public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private DiscussPostExtMapper discussPostExtMapper;

    @Test
    public User selectById(int id){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdEqualTo(id);
        User user = userMapper.selectByExample(userExample).get(0);
        return user;
    }

    @Test
    public void selectDiscussPostTest(){
        DiscussPostExample discussPostExample = new DiscussPostExample();
        discussPostExample.createCriteria().andUserIdIsNotNull()
                .andUserIdEqualTo(String.valueOf(149))
                .andStatusNotEqualTo(2);
        discussPostExample.setOrderByClause("type desc,create_time desc");
        List<DiscussPost> discussPosts = discussPostMapper.selectByExampleWithRowbounds(discussPostExample, new RowBounds(0, 2));
        //List<DiscussPost> discussPosts = discussPostMapper.selectByExampleWithBLOBs(discussPostExample);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }

    @Test
    public void selectDiscussPostExtTest(){
        int postRows = discussPostExtMapper.selectDiscussPostRows(101);
        System.out.println(postRows);

        int allRows = discussPostExtMapper.selectDiscussPostRows(0);
        System.out.println(allRows);

        List<DiscussPost> discussPosts = discussPostExtMapper.selectDiscussPosts(101, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }
    }

}
