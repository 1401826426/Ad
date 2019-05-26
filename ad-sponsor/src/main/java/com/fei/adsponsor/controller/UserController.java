package com.fei.adsponsor.controller;

import com.fei.adsponsor.service.IUserService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/adUser")
public class UserController {

    @Autowired
    private IUserService userService ;

    @PostMapping("/create")
    public ResultVO<UserDto> create(@RequestParam("username") String username){
        UserDto userDto = userService.createUser(username) ;
        return ResultVO.ok(userDto) ;
    }

    @PostMapping("/login")
    public ResultVO<UserDto> login(String username, HttpServletResponse response){
        UserDto userDto = userService.login(response,username) ;
        return ResultVO.ok(userDto) ;
    }

}
