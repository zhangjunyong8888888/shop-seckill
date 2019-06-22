package com.study.enums;


import lombok.Getter;


/**
 * 秒杀状态枚举
 */
@Getter
public enum SeckillStatusEnum {
    /**
     * 未开始
     */
    NOT_STARTED(0),
    /**
     * 进行中
     */
    PROGRESS(1),
    /**
     * 已结束
     */
    FINISHED(2),
    ;

    private Integer code;

    SeckillStatusEnum(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
