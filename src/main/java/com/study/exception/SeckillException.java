package com.study.exception;


import com.study.result.CodeMsg;
import lombok.Getter;


@Getter
public class SeckillException extends RuntimeException {

    private CodeMsg codeMsg;

    public SeckillException(CodeMsg codeMsg) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }
}
