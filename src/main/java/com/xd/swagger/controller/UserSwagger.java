package com.xd.swagger.controller;

import com.xd.common.domain.Api;
import com.xd.common.domain.User;
import com.xd.swagger.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zlj on 2020/1/22.
 * Project Name : SpringCloud
 * Package Name : com.xd.swagger.controller
 */
@EnableSwagger2
@RestController
public class UserSwagger {
    @Value("${server.port}")  //该服务的端口号
    private String port;
    @Autowired
    private UserService userService;

    //    根据Id查询用户
    @ApiOperation(value = "根据Id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户Id",required = true,dataType = "String",paramType = "path")
    })
    @RequestMapping(value = "GetUserById/{userid}",method = RequestMethod.GET)
    public Api GetUserById(@PathVariable(value = "userid") String userid){
        Api api = new Api();
        System.out.printf("\n\nid="+userid);
        User user = userService.selectUserById(userid);
        api.setCode(200);
        api.setMessage("成功");
        api.setData(user);
        return api;
    }

    //    根据Id查询用户
    @ApiOperation(value = "根据Id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid",value = "用户Id",required = true,dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "GetUserById",method = RequestMethod.GET)
    public Api GetUserById1(@RequestParam(value = "userid") String userid){
        Api api = new Api();
        System.out.printf("\n\nid="+userid);
        User user = userService.selectUserById(userid);
        api.setCode(200);
        api.setMessage("成功");
        api.setData(user);
        return api;
    }
}
