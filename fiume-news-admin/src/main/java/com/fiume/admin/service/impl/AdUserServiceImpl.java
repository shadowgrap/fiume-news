package com.fiume.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiume.admin.mapper.AdUserMapper;
import com.fiume.admin.service.AdUserService;
import com.fiume.model.admin.dtos.AdUserDto;
import com.fiume.model.admin.pojos.AdUser;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import com.fiume.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Fiume
 * @since : 2021/10/12 21:12
 */
@Service
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {
    /**
     * 管理员用户登录
     *
     * @param adUserDto 管理员dto类
     * @return 登录是否成功
     */
    @Override
    public ResponseResult login(AdUserDto adUserDto) {
        //1.检查参数
        if (StringUtils.isEmpty(adUserDto.getName()) || StringUtils.isEmpty(adUserDto.getPassword())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户名或密码为空");
        }
        //2.根据id从数据库中取出user对象
        AdUser adUser = getOne(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName, adUserDto.getName()));
        if (adUser == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
        }

        //3.dto的密码加盐加密后和数据库中的密码比较
        String password = DigestUtils.md5DigestAsHex((adUserDto.getPassword() + adUser.getSalt()).getBytes());
        System.out.println("password = " + password);
        if (password.equals(adUser.getPassword())) {
            Map map = new HashMap<>();
            String token = AppJwtUtil.getToken(Long.valueOf(adUser.getId()));
            map.put("token", token);
            adUser.setSalt("");
            adUser.setPassword("");
            map.put("user",adUser);

            return ResponseResult.okResult(map);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }
    }
}
