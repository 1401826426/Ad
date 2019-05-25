package com.fei.adsponsor.controller;

import com.fei.adsponsor.service.IUserService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService ;

    @PostMapping("/create")
    public ResultVO<UserDto> create(@RequestParam("username") String username){
        UserDto userDto = userService.createUser(username) ;
        return ResultVO.ok(userDto) ;
    }

}
