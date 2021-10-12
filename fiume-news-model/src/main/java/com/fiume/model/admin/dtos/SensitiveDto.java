package com.fiume.model.admin.dtos;

import com.fiume.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : Fiume
 * @since : 2021/10/12 14:29
 */
@Data
@ApiModel("敏感词dto类")
public class SensitiveDto extends PageRequestDto {

    @ApiModelProperty("敏感词名称")
    private String name;
}
