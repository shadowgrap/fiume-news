package com.fiume.admin.controller.v1;

import com.fiume.admin.service.AdChannelService;
import com.fiume.apis.admin.AdChannelControllerApi;
import com.fiume.model.admin.dtos.ChannelDto;
import com.fiume.model.admin.pojos.AdChannel;
import com.fiume.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Fiume
 * @since : 2021/10/8 17:42
 */
@RestController
@RequestMapping("/api/v1/channel")
public class AdChannelController implements AdChannelControllerApi {

    @Autowired
    private AdChannelService channelService;

    /**
     * 根据名称分页查询频道列表
     *
     * @param dto
     * @return 频道列表
     */

    @PostMapping("/list")
    @Override
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto dto) {

        return channelService.findByNameAndPage(dto);
    }

    /**
     * 新增
     *
     * @param adChannel
     * @return 新增结果
     */
    @Override
    @PostMapping("/save")
    public ResponseResult save(@RequestBody AdChannel adChannel) {
        return channelService.insert(adChannel);
    }


    @Override
    @PostMapping("/update")
    public ResponseResult update(@RequestBody AdChannel adChannel) {
        return channelService.update(adChannel);
    }

    @Override
    @GetMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return channelService.deleteById(id);
    }
}
