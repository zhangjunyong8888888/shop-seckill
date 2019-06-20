package com.study.bean.param;


import com.study.annotation.Mobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


@Data
public class LoginParam {

    @NotBlank(message = "手机号不能为空")
    @Mobile
    private String mobile;
    @NotBlank(message = "密码不能为空")
    @Length
    private String password;

}
