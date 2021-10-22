package com.fiume.user.controller.v1;

import com.fiume.apis.user.ApUserRealnameControllerApi;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.user.dtos.AuthDto;
import com.fiume.user.service.ApUserRealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Fiume
 * @since : 2021/10/20 19:21
 */
@RestController
@RequestMapping("/api/v1/auth")
public class ApUserRealnameController implements ApUserRealnameControllerApi {

    @Autowired
    private ApUserRealnameService apUserRealnameService;

    @PostMapping("/list")
    @Override
    public ResponseResult findListByStatus(@RequestBody AuthDto dto) {
        return apUserRealnameService.findListByStatus(dto);
    }
}