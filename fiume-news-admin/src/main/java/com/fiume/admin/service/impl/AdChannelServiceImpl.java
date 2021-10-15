package com.fiume.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiume.admin.mapper.AdChannelMapper;
import com.fiume.admin.service.AdChannelService;
import com.fiume.model.admin.dtos.ChannelDto;
import com.fiume.model.admin.pojos.AdChannel;
import com.fiume.model.common.dtos.PageResponseResult;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : Fiume
 * @since : 2021/10/8 17:05
 */
@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {
    /**
     * 根据名称分页查询频道列表
     *
     * @param dto
     * @return 频道列表
     */
    @Override
    public ResponseResult findByNameAndPage(ChannelDto dto) {

        //1.参数检测
        if (dto == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //检查分页参数
        dto.checkParam();
        //2.按照名称模糊分页查询
        Page<AdChannel> page = new Page<>(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<AdChannel> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNoneBlank(dto.getName())) {
            lambdaQueryWrapper.like(AdChannel::getName, dto.getName());
        }
        IPage<AdChannel> result = page(page, lambdaQueryWrapper);
        //3.结果封装
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(),result.getTotal());
        responseResult.setData(result.getRecords());
        return responseResult;
    }

    @Override
    public ResponseResult insert(AdChannel adChannel) {
        //1.参数检查
        if (adChannel == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.保存数据到数据库
        adChannel.setIsDefault(false);
        adChannel.setCreatedTime(new Date());
        boolean result = save(adChannel);
        if (result) {
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "数据不符合标准,数据库插入失败");
    }

    @Override
    public ResponseResult update(AdChannel adChannel) {
        //1.参数检查
        if (adChannel == null || adChannel.getId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.修改
        boolean result = updateById(adChannel);
        if (result) {
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR, "数据库更新数据失败");
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        //1.检查参数
        if (id == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.判断当前频道是否存在和有效
        AdChannel adChannel = getById(id);
        if (adChannel == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "不存在该频道");
        }
        //3.删除频道
        boolean result = removeById(id);

        if (result) {
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR, "deleteById:从数据库删除该数据失败");
    }
}
