package com.xd.swagger.serviceImpl;

import com.xd.common.domain.User;
import com.xd.swagger.mapper.UserMapper;
import com.xd.swagger.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张立军 on 2020/1/15.
 * Project Name : SpringCloud
 * Package Name : com.xd.swagger.ServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(@Param("userid")String userid) {
        User user = userMapper.selectUserById(userid);
        return user;
    }
}
