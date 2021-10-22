package com.fiume.model.user.dtos;

import com.fiume.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : Fiume
 * @since : 2021/10/15 17:55
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel("用户实名认证dto类")
@Data
public class AuthDto extends PageRequestDto {
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("错误提示信息")
    private String msg;
    @ApiModelProperty("状态")
    private Short status;
}
