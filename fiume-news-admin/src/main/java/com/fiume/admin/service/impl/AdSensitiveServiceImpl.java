package com.fiume.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiume.admin.mapper.AdSensitiveMapper;
import com.fiume.admin.service.AdSensitiveService;
import com.fiume.model.admin.dtos.SensitiveDto;
import com.fiume.model.admin.pojos.AdSensitive;
import com.fiume.model.common.dtos.PageResponseResult;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : Fiume
 * @since : 2021/10/12 14:36
 */
@Service
public class AdSensitiveServiceImpl extends ServiceImpl<AdSensitiveMapper, AdSensitive> implements AdSensitiveService {
    /**
     * 根据分页查询敏感词
     *
     * @param dto 敏感词dto类
     * @return 敏感词列表
     */
    @Override
    public ResponseResult list(SensitiveDto dto) {
        //1.检查参数
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //1.2检查分页参数,若为空,则赋默认值
        dto.checkParam();

        //2.根据名称模糊查询
        Page<AdSensitive> adSensitivePage = new Page<>(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<AdSensitive> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(dto.getName())) {
            queryWrapper.like(AdSensitive::getSensitives, dto.getName());
        }
        IPage<AdSensitive> result = page(adSensitivePage, queryWrapper);
        //3.返回结果
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) result.getTotal());
        responseResult.setData(result.getRecords());
        return responseResult;
    }

    /**
     * 新增敏感词
     *
     * @param adSensitive 要新增的敏感词
     * @return 新增结果
     */
    @Override
    public ResponseResult insert(AdSensitive adSensitive) {
        //1.检查参数
        if (adSensitive == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.新增敏感词
        adSensitive.setCreatedTime(new Date());
        boolean result = save(adSensitive);
        //3.返回结果
        if (result) {
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR, "adSensitive:insert 数据库返回错误");
    }

    /**
     * 修改敏感词
     *
     * @param adSensitive 要修改的敏感词相关信息
     * @return 修改结果
     */
    @Override
    public ResponseResult update(AdSensitive adSensitive) {
        if (adSensitive == null || adSensitive.getId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        boolean result = this.updateById(adSensitive);
        if (result) {
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR,"adSensitiveService:update,数据库插入错误");
    }

    /**
     * 删除敏感词
     *
     * @param id 敏感词的id
     * @return 删除的结果
     */
    @Override
    public ResponseResult deleteById(Integer id) {
        if (id == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        AdSensitive adSensitive = this.getById(id);
        if (adSensitive == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.AP_USER_DATA_NOT_EXIST,"关键词数据不存在");
        }

        boolean result = this.removeById(id);
        if (result){
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }

        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR,"删除失败");
    }
}
