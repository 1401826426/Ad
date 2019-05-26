package com.fei.adsponsor.controller;

import com.fei.adsponsor.entity.AdCreative;
import com.fei.adsponsor.service.IAdCreativeService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.CodeMsg;
import com.fei.common.ResultVO;
import com.fei.common.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creative")
public class AdCreativeController {

    @Autowired
    private IAdCreativeService adCreativeService ;

    public ResultVO<AdCreative> create(@RequestBody AdCreative adCreative, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        AdCreative result = adCreativeService.create(adCreative,userDto.getId()) ;
        return ResultVO.ok(result) ;
    }

}
