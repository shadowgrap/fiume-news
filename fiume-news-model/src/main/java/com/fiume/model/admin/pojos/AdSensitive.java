package com.fiume.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 敏感词信息表
 * @TableName ad_sensitive
 */
@TableName(value ="ad_sensitive")
@Data
public class AdSensitive implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 敏感词
     */
    @TableField("sensitives")
    @ApiModelProperty("敏感词")
    private String sensitives;

    /**
     * 创建时间
     */
    @TableField("created_time")
    @ApiModelProperty("创建时间")
    private Date createdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}