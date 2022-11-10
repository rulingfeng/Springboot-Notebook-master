package io.seata.sample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.*;

/**
 * 全局统一处理所有异常
 *
 * @author yingyongzhi
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = {GlobalException.class})
    public Result GlobalExceptionHandler(GlobalException e) {
        return Result.error(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = {BizException.class})
    public Result BizExceptionHandler(BizException e) {
        return Result.error(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(Exception e) throws Exception {
        throw e;
//        return Result.error(ResultEnum.NETWORK_DESERTED_PLEASE_TRY_AGAIN_LATER.getMsg(), ResultEnum.NETWORK_DESERTED_PLEASE_TRY_AGAIN_LATER.getCode());

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result MyExceptionHandle(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> {
                System.out.println("请求参验证：字段 " + error.getField() + ", msg：" + error.getDefaultMessage());
                errorMsg.append(error.getDefaultMessage()).append("!");
            });
        }
        return Result.error(errorMsg.toString(), ResultEnum.PARAM_ERROR_CODE.getCode());
    }
}

