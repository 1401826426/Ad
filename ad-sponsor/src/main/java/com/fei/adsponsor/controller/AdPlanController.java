package com.fei.adsponsor.controller;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.service.impl.AdPlanService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.CodeMsg;
import com.fei.common.ResultVO;
import com.fei.common.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adPlan")
public class AdPlanController {

    @Autowired
    private AdPlanService adPlanService ;

    @PostMapping("/create")
    public ResultVO<AdPlan> create(@RequestBody AdPlan adPlan, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        AdPlan result = adPlanService.create(adPlan,userDto.getId()) ;
        return ResultVO.ok(result) ;
    }

    @PostMapping("/update")
    public ResultVO<AdPlan> update(@RequestBody AdPlan adPlan, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        AdPlan result = adPlanService.update(adPlan,userDto.getId()) ;
        return ResultVO.ok(result) ;
    }

    @DeleteMapping("/delete")
    public ResultVO<Boolean> update(@RequestParam("id") long id, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        boolean success = adPlanService.delete(id,userDto.getId()) ;
        return ResultVO.ok(success) ;
    }

    @GetMapping("/find/all")
    public ResultVO<List<AdPlan>> findAl(UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        List<AdPlan> adPlanList = adPlanService.findByUserId(userDto.getId()) ;
        return ResultVO.ok(adPlanList) ;
    }



}
