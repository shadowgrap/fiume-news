package com.fiume.apis.wemedia;

import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.media.pojos.WmUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/22 19:38
 */
@Api(value = "自媒体用户管理",tags = "wmuserCntroller")
public interface WmUserControllerApi {
    /**
     * 保存自媒体用户
     * @param wmUser 自媒体用户
     * @return 保存结果
     */
    @ApiOperation("保存自媒体用户")
    ResponseResult save(WmUser wmUser);

    /**
     * 根据名称查询用户
     * @param name 用户名
     * @return 用户信息
     */
    @ApiOperation("更加名称查询自媒体用户")
    ResponseResult findByName(String name);
}
