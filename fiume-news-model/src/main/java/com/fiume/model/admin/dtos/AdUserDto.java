package com.fiume.model.admin.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : Fiume
 * @since : 2021/10/12 20:56
 */
@Data
@ApiModel("管理员登录dto类")
public class AdUserDto {

    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
}
