package com.xd.swagger.service;

import com.xd.common.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by 张立军 on 2020/1/15.
 * Project Name : SpringCloud
 * Package Name : com.xd.swagger.service
 */
@Service
public interface UserService {
    User selectUserById(@Param("userid") String userid);
}
