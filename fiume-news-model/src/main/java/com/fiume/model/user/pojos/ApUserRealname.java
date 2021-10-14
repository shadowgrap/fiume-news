package com.fiume.model.user.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * APP实名认证信息表
 *
 * @author : Fiume
 * @since : 2021/10/14 21:09
 */
@TableName(value ="ap_user_realname")
@Data
public class ApUserRealname implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 账号ID
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 资源名称
     */
    private String idno;

    /**
     * 正面照片
     */
    private String fontImage;

    /**
     * 背面照片
     */
    private String backImage;

    /**
     * 手持照片
     */
    private String holdImage;

    /**
     * 活体照片
     */
    private String liveImage;

    /**
     * 状态
     0 创建中
     1 待审核
     2 审核失败
     9 审核通过
     */
    private Boolean status;

    /**
     * 拒绝原因
     */
    private String reason;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 提交时间
     */
    private LocalDateTime submitedTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
