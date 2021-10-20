package com.bokchoy.nowcode_community.mapper;

import com.bokchoy.nowcode_community.entity.DiscussPost;
import com.bokchoy.nowcode_community.entity.DiscussPostExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DiscussPostExtMapper {
    //范围查询 其中userId是动态的参数，当userId=0时，sql语句就不会加上该条件；
    List<DiscussPost> selectDiscussPosts(int userId,int offset, int limit);

    //@Param("userId")给参数取别名，当只有一个参数时且需要用到动态条件时必须加别名
    int selectDiscussPostRows(@Param("userId") int userID);
}