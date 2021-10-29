package com.fiume.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import com.fiume.model.media.pojos.WmUser;
import com.fiume.wemedia.mapper.WmUserMapper;
import com.fiume.wemedia.service.WmUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
@Service
public class WmUserServiceImpl extends ServiceImpl<WmUserMapper, WmUser>
    implements WmUserService {


    @Override
    public ResponseResult findByName(String name) {

        if (name.isEmpty()){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"参数不能为空");
        }
        LambdaQueryWrapper<WmUser> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(WmUser::getName, name);
        List<WmUser> list = this.list(wrapper);
        if (list != null && !list.isEmpty()){
            return ResponseResult.okResult(list.get(0));
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST,"数据不存在");
    }
}




