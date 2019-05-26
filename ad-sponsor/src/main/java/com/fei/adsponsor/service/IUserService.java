package com.fei.adsponsor.service;

import com.fei.adsponsor.vo.UserDto;

import javax.servlet.http.HttpServletResponse;

public interface IUserService {

    UserDto createUser(String username) ;

    UserDto login(HttpServletResponse response, String username) ;

}
