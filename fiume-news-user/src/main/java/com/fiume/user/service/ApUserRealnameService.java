package com.fiume.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.user.dtos.AuthDto;
import com.fiume.model.user.pojos.ApUserRealname;

/**
 *
 */
public interface ApUserRealnameService extends IService<ApUserRealname> {

    /**
     * 根据状态查询实名认证列表
     * @param dto 用户实名认证权限dtd
     * @return 实名认证列表
     */
    ResponseResult findListByStatus(AuthDto dto);

}
