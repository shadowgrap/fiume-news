package com.fiume.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiume.model.admin.dtos.AdUserDto;
import com.fiume.model.admin.pojos.AdUser;
import com.fiume.model.common.dtos.ResponseResult;

/**
 * @author : Fiume
 * @since : 2021/10/12 21:10
 */
public interface AdUserService extends IService<AdUser> {
    /**
     * 管理员用户登录
     * @param adUserDto 管理员dto类
     * @return 登录是否成功
     */
    ResponseResult login(AdUserDto adUserDto);
}
