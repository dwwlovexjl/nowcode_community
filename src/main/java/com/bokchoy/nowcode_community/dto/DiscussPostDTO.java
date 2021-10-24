package com.bokchoy.nowcode_community.dto;

import com.bokchoy.nowcode_community.entity.DiscussPost;
import com.bokchoy.nowcode_community.entity.User;

/**
 * @author bokchoy
 * @description: 帖子 包含用户信息
 * @date 2021年10月24日 16:47
 */
public class DiscussPostDTO {
    private DiscussPost discussPost;
    private User user;

    public DiscussPost getDiscussPost() {
        return discussPost;
    }

    public void setDiscussPost(DiscussPost discussPost) {
        this.discussPost = discussPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
