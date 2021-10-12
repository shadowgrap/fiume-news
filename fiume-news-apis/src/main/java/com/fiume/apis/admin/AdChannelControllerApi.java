package com.fiume.apis.admin;

import com.fiume.model.admin.dtos.ChannelDto;
import com.fiume.model.admin.pojos.AdChannel;
import com.fiume.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/8 16:13
 */
@Api(value = "频道管理", tags = "channel", description = "频道管理API")
public interface AdChannelControllerApi {
    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return 频道列表
     */
    @ApiOperation("频道分页列表查询")
    ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 新增
     * @param adChannel
     * @return 新增结果
     */
    @ApiOperation("添加频道")
    ResponseResult save(AdChannel adChannel);

    /**
     * 修改
     * @param adChannel 要修改的频道信息
     * @return 修改结果
     */
    @ApiOperation("修改频道")
    ResponseResult update(AdChannel adChannel);

    @ApiOperation("通过id删除频道")
    ResponseResult deleteById(Integer id);
}
