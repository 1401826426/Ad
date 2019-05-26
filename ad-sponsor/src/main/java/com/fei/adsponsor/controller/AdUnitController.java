package com.fei.adsponsor.controller;

import com.fei.adsponsor.entity.AdUnit;
import com.fei.adsponsor.entity.CreativeUnit;
import com.fei.adsponsor.entity.unit_condition.AdUnitDistrict;
import com.fei.adsponsor.entity.unit_condition.AdUnitIt;
import com.fei.adsponsor.entity.unit_condition.AdUnitKeyword;
import com.fei.adsponsor.service.IAdUnitService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.CodeMsg;
import com.fei.common.ResultVO;
import com.fei.common.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unit")
public class AdUnitController {

    @Autowired
    private IAdUnitService adUnitService ;

    @PostMapping("/create")
    public ResultVO<AdUnit> create(@RequestBody  AdUnit adUnit, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        AdUnit result = adUnitService.create(adUnit) ;
        return ResultVO.ok(result);
    }

    @PostMapping("/createUnitIts")
    public ResultVO<List<Long>> createUnitIts(@RequestBody List<AdUnitIt> unitIts, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        List<Long> ids = adUnitService.createUnitIts(unitIts);
        return ResultVO.ok(ids);
    }

    @PostMapping("/createUnitKeyWords")
    public ResultVO<List<Long>> createUnitKeyWords(@RequestBody List<AdUnitKeyword> unitKeywords, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        List<Long> ids = adUnitService.createUnitKeywords(unitKeywords) ;
        return ResultVO.ok(ids);
    }

    @PostMapping("/createUnitDistricts")
    public ResultVO<List<Long>> createUnitDistricts(@RequestBody List<AdUnitDistrict> unitDistricts, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        List<Long> ids = adUnitService.createUnitDistrict(unitDistricts);
        return ResultVO.ok(ids);
    }

    @PostMapping("/create/unit/creative")
    public ResultVO<List<Long>> createUnitCreative(@RequestBody List<CreativeUnit> creativeUnits, UserDto userDto){
        if(userDto == null){
            throw new GlobalException(CodeMsg.NO_USER) ;
        }
        List<Long> ids = adUnitService.createCreativeUnit(creativeUnits) ;
        return ResultVO.ok(ids);
    }


}















