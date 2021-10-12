package com.fiume.common.exception;

import com.fiume.model.common.dtos.ResponseResult;
import com.fiume.model.common.enums.AppHttpCodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 通用异常处理类,一些未定义的异常,通过该类处理后,返回给前端一个指定的值
 *
 * @author : Fiume
 * @since : 2021/10/11 13:23
 */
@ControllerAdvice //增强控制器
@Log4j2
public class ExceptionCatch {
    /**
     * @ExceptionHandler 捕获异常
     * @ResponseBody 将返回值序列化
     * @param exception 捕获controller层未处理的异常
     * @return 统一返回值,返回503服务器内部错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        exception.printStackTrace();
        //日志记录
        log.error("catch exception:{}",exception.getMessage());
        //返回通用异常
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR);
    }
}
