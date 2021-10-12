package com.fiume.apis.admin;

import com.fiume.model.admin.dtos.SensitiveDto;
import com.fiume.model.admin.pojos.AdSensitive;
import com.fiume.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/12 14:21
 */
@Api(value = "敏感词管理", tags = "sensitive")
public interface AdSensitiveControllerApi {

    @ApiOperation("根据分页查询敏感词")
    ResponseResult list(SensitiveDto dto);

    @ApiOperation("新增敏感词")
    ResponseResult save(AdSensitive adSensitive);

    @ApiOperation("修改敏感词")
    ResponseResult update(AdSensitive adSensitive);

    @ApiOperation("删除敏感词")
    ResponseResult deleteById(Integer id);
}
