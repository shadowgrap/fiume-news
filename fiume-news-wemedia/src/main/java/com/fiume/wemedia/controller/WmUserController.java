package com.fiume.wemedia.controller;

import com.fiume.apis.wemedia.WmUserControllerApi;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.media.pojos.WmUser;
import com.fiume.wemedia.service.WmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author : Fiume
 * @since : 2021/10/22 19:45
 */
@RestController
@RequestMapping("/api/v1/user")
public class WmUserController implements WmUserControllerApi {

    @Autowired
    private WmUserService wmUserService;

    /**
     * 保存自媒体用户
     *
     * @param wmUser 自媒体用户
     * @return 保存结果
     */
    @PostMapping("/save")
    @Override
    public ResponseResult save(@RequestBody WmUser wmUser) {
        wmUser.setCreatedTime(new Date());
        wmUserService.save(wmUser);
        return ResponseResult.okResult();
    }

    /**
     * 根据名称查询用户
     *
     * @param name 用户名
     * @return 用户信息
     */
    @GetMapping("/findByName/{name}")
    @Override
    public ResponseResult findByName(@PathVariable("name") String name) {
        return wmUserService.findByName(name);
    }
}
