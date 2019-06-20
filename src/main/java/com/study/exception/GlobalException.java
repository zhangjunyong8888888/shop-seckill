package com.study.exception;


import com.study.result.CodeMsg;
import lombok.Getter;


@Getter
public class GlobalException extends RuntimeException{

    private CodeMsg codeMsg;

    public GlobalException(CodeMsg codeMsg){
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }
}
