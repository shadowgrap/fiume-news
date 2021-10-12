package com.fiume.apis.admin;

import com.fiume.model.admin.dtos.AdUserDto;
import com.fiume.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/12 20:53
 */
@Api(value = "管理员登录管理",tags = "AdLogin")
public interface LoginControllerApi {

    @ApiOperation("admin登录功能")
    ResponseResult login(AdUserDto adUserDto);
}
