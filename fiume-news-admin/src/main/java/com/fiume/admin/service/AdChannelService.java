package com.fiume.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fiume.model.admin.dtos.ChannelDto;
import com.fiume.model.admin.pojos.AdChannel;
import com.fiume.model.common.dtos.ResponseResult;

/**
 * @author : Fiume
 * @since : 2021/10/8 17:03
 */
public interface AdChannelService extends IService<AdChannel> {

    /**
     * 根据名称分页查询频道列表
     * @param dto 分页信息
     * @return 频道列表
     */
    ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 新增方法业务层
     * @param adChannel 要新增的频道信息
     * @return 新增结果
     */
    ResponseResult insert(AdChannel adChannel);

    /**
     * 修改方法业务层
     * @param adChannel 要修改的频道
     * @return 修改结果
     */
    ResponseResult update(AdChannel adChannel);

    /**
     * 通过id删除频道
     * @param id 频道id
     * @return 删除结果
     */
    ResponseResult deleteById(Integer id);
}
