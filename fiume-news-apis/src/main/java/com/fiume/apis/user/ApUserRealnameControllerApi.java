package com.fiume.apis.user;

import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.user.dtos.AuthDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/15 17:50
 */
@Api(value = "用户实名认证管理", tags = "ApUser_Realname")
public interface ApUserRealnameControllerApi {
    @ApiOperation("根据状态查询实名认证列表")
    ResponseResult findListByStatus(AuthDto dto);
}
