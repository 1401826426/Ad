package com.fei.adsponsor.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private long id ;

    private String username ;

    private String token ;

    private Date updateTime ;

    private Date createTime ;


}
