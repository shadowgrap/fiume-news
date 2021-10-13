package com.fiume.admin.controller.v1;

import com.fiume.admin.service.AdUserService;
import com.fiume.apis.admin.LoginControllerApi;
import com.fiume.model.admin.dtos.AdUserDto;
import com.fiume.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Fiume
 * @since : 2021/10/13 9:33
 */
@RestController
@RequestMapping("/login")
public class LoginController implements LoginControllerApi {

    @Autowired
    private AdUserService adUserService;

    @Override
    @PostMapping("/in")
    public ResponseResult login(@RequestBody AdUserDto adUserDto) {
        return adUserService.login(adUserDto);
    }
}
