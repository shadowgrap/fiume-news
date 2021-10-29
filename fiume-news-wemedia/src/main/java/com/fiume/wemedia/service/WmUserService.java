package com.fiume.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.media.pojos.WmUser;

/**
 *
 */
public interface WmUserService extends IService<WmUser> {

    ResponseResult findByName(String name);
}
