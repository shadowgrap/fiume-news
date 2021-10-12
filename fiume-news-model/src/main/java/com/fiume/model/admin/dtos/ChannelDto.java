package com.fiume.model.admin.dtos;

import com.fiume.model.common.dtos.PageRequestDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 请求参数实体类
 * @author : Fiume
 * @since : 2021/10/8 16:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("频道Dto")
public class ChannelDto extends PageRequestDto {
    /**
     * 频道名称
     */
    @ApiModelProperty("频道名称")
    private String name;

}
