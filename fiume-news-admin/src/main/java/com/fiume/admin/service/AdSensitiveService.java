package com.fiume.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiume.model.admin.dtos.SensitiveDto;
import com.fiume.model.admin.pojos.AdSensitive;
import com.fiume.model.common.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : Fiume
 * @since : 2021/10/12 14:35
 */
public interface AdSensitiveService extends IService<AdSensitive> {

    /**
     * 根据分页查询敏感词
     * @param dto 敏感词dto类
     * @return 敏感词列表
     */
    ResponseResult list(SensitiveDto dto);

    /**
     * 新增敏感词
     * @param adSensitive 要新增的敏感词
     * @return 新增结果
     */
    ResponseResult insert(AdSensitive adSensitive);

    /**
     * 修改敏感词
     * @param adSensitive 要修改的敏感词相关信息
     * @return 修改结果
     */
    ResponseResult update(AdSensitive adSensitive);

    /**
     * 删除敏感词
     * @param id 敏感词的id
     * @return 删除的结果
     */
    ResponseResult deleteById(Integer id);
}
