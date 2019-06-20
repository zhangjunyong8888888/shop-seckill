package com.study.bean.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private LocalDateTime registerTime;
    private LocalDateTime lastLoginTime;
    private Integer loginCount;


}
