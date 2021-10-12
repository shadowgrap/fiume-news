package com.fiume.admin.controller.v1;

import com.fiume.admin.service.AdSensitiveService;
import com.fiume.apis.admin.AdSensitiveControllerApi;
import com.fiume.model.admin.dtos.SensitiveDto;
import com.fiume.model.admin.pojos.AdSensitive;
import com.fiume.model.common.dtos.ResponseResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Fiume
 * @since : 2021/10/12 15:15
 */
@RequestMapping("/api/v1/sensitive")
@RestController
public class AdSensitiveController implements AdSensitiveControllerApi {

    @Autowired
    private AdSensitiveService adSensitiveService;

    @Override
    @PostMapping("/list")
    public ResponseResult list(@RequestBody SensitiveDto dto) {
        return adSensitiveService.list(dto);
    }

    @Override
    @PostMapping("/save")
    public ResponseResult save(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.insert(adSensitive);
    }

    @Override
    @PostMapping("/update")
    public ResponseResult update(@RequestBody AdSensitive adSensitive) {
        return adSensitiveService.update(adSensitive);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable("id") Integer id) {
        return adSensitiveService.deleteById(id);
    }
}
