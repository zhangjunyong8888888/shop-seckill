package com.study.exception.handler;


import com.study.exception.GlobalException;
import com.study.result.CodeMsg;
import com.study.result.Result;
import lombok.extern.java.Log;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Log
public class GlobalExceptionHandler {

    /**
     * 参数验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result dealBindException(BindException e){
        return Result.error(CodeMsg.BIND_ERROR.fillArgs(e.getAllErrors().get(0).getDefaultMessage()));
    }

    /**
     * 抛出的已知异常
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public Result dealGlobalException(GlobalException e){
        return Result.error(e.getCodeMsg());
    }
}
