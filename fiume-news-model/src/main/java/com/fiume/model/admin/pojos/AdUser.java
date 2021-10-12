package com.fiume.model.admin.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 管理员用户信息表
 *
 * @author : Fiume
 * @since : 2021/10/12 20:47
 */
@Data
@TableName("ad_user")
@ApiModel("管理员用户信息表")
public class AdUser implements Serializable {
    /**
     * 主键
     */
    @TableId
    @ApiModelProperty("主键")
    private Integer id;

    /**
     * 登录用户名
     */
    @ApiModelProperty("登录用户名")
    private String name;

    /**
     * 登录密码
     */
    @ApiModelProperty("登录密码")
    private String password;

    /**
     * 盐
     */
    @ApiModelProperty("盐")
    private String salt;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String image;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 状态
     0 暂时不可用
     1 永久不可用
     9 正常可用
     */
    @ApiModelProperty("状态")
    private Byte status;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 最后一次登录时间
     */
    @ApiModelProperty("最后一次登录时间")
    private Date loginTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
