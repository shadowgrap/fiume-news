package com.fiume.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fiume.model.common.dtos.PageResponseResult;
import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import com.fiume.model.user.dtos.AuthDto;
import com.fiume.model.user.pojos.ApUserRealname;
import com.fiume.user.mapper.ApUserRealnameMapper;
import com.fiume.user.service.ApUserRealnameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
@Slf4j
public class ApUserRealnameServiceImpl extends ServiceImpl<ApUserRealnameMapper, ApUserRealname>
    implements ApUserRealnameService {


    /**
     * 根据状态查询实名认证列表
     *
     * @param dto 用户实名认证权限dtd
     * @return 实名认证列表
     */
    @Override
    public ResponseResult findListByStatus(AuthDto dto) {
        //1.校验参数
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.封装条件
        //page条件
        Page<ApUserRealname> realnamePage = new Page<>(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<ApUserRealname> wrapper = Wrappers.lambdaQuery();
        // 添加查询条件,即当前用户状态查询,如果用户想要查询特定状态的信息
        if (dto.getStatus() != null){
            wrapper.eq(ApUserRealname::getStatus,dto.getStatus());
        }
        //3.执行查询
        IPage<ApUserRealname> page = page(realnamePage, wrapper);
        //4.封装结果
        ResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), page.getTotal());
        responseResult.setData(page.getRecords());
        //return ResponseResult.okResult(page);
        return responseResult;
    }
}




