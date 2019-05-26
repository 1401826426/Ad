package com.fei.adsponsor.service.impl;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.AdUnit;
import com.fei.adsponsor.entity.CreativeUnit;
import com.fei.adsponsor.entity.unit_condition.AdUnitDistrict;
import com.fei.adsponsor.entity.unit_condition.AdUnitIt;
import com.fei.adsponsor.entity.unit_condition.AdUnitKeyword;
import com.fei.adsponsor.repository.*;
import com.fei.adsponsor.service.IAdUnitService;
import com.fei.common.CodeMsg;
import com.fei.common.exception.GlobalException;
import com.fei.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdUnitService implements IAdUnitService {

    @Autowired
    private AdUnitRepository adUnitRepository ;
    @Autowired
    private AdUnitKeywordRepository adUnitKeywordRepository ;
    @Autowired
    private AdUnitDistrictRepository adUnitDistrictRepository ;
    @Autowired
    private AdUnitItRepository adUnitItRepository;
    @Autowired
    private AdPlanRepository adPlanRepository ;
    @Autowired
    private AdCreativeRepository adCreativeRepository ;
    @Autowired
    private AdCreativeUnitRepository adCreativeUnitRepository ;

    @Override
    public AdUnit create(AdUnit adUnit) {
        if(StringUtils.isBlank(adUnit.getUnitName())){
            throw new GlobalException(CodeMsg.NO_UNIT_NAME) ;
        }
        Optional<AdPlan> optional = adPlanRepository.findById(adUnit.getPlanId()) ;
        if(!optional.isPresent()){
            throw new GlobalException(CodeMsg.NO_PLAN) ;
        }
        AdUnit dbAdUnit = adUnitRepository.findByPlanIdAndUnitName(adUnit.getPlanId(),adUnit.getUnitName()) ;
        if(dbAdUnit != null){
            throw new GlobalException(CodeMsg.ALREADY_HAS_UNIT_NAME) ;
        }
        AdUnit createUnit = new AdUnit(adUnit.getPlanId(),adUnit.getUnitName()
                ,adUnit.getPositionType(),adUnit.getBudget()) ;
        adUnitRepository.save(createUnit) ;
        return createUnit;
    }

    @Override
    public List<Long> createUnitIts(List<AdUnitIt> adUnits) {
        Set<Long> ids = adUnits.stream().map(AdUnitIt::getUnitId).collect(Collectors.toSet()) ;
        if(!checkUnitExsist(ids)){
            throw new GlobalException(CodeMsg.EXSIST_NO_UNIT_IDS) ;
        }
        List<Long> saveIds = adUnitItRepository.saveAll(adUnits).stream().map(AdUnitIt::getId).collect(Collectors.toList()) ;
        return saveIds;
    }

    @Override
    public List<Long> createUnitKeywords(List<AdUnitKeyword> adUnitKeywords) {
        Set<Long> ids = adUnitKeywords.stream().map(AdUnitKeyword::getUnitId).collect(Collectors.toSet()) ;
        if(!checkUnitExsist(ids)){
            throw new GlobalException(CodeMsg.EXSIST_NO_UNIT_IDS) ;
        }
        List<Long> saveIds = adUnitKeywordRepository.saveAll(adUnitKeywords).stream().map(AdUnitKeyword::getId).collect(Collectors.toList()) ;
        return saveIds;
    }

    @Override
    public List<Long> createUnitDistrict(List<AdUnitDistrict> adUnitDistricts) {
        Set<Long> ids = adUnitDistricts.stream().map(AdUnitDistrict::getUnitId).collect(Collectors.toSet()) ;
        if(!checkUnitExsist(ids)){
            throw new GlobalException(CodeMsg.EXSIST_NO_UNIT_IDS) ;
        }
        List<Long> saveIds = adUnitDistrictRepository.saveAll(adUnitDistricts).stream().map(AdUnitDistrict::getUnitId).collect(Collectors.toList());
        return saveIds;
    }

    @Override
    public List<Long> createCreativeUnit(List<CreativeUnit> creativeUnits) {
        Set<Long> unitIds = creativeUnits.stream().map(CreativeUnit::getUnitId).collect(Collectors.toSet());
        if(!checkUnitExsist(unitIds)){
            throw new GlobalException(CodeMsg.EXSIST_NO_UNIT_IDS) ;
        }
        Set<Long> creativeIds = creativeUnits.stream().map(CreativeUnit::getCreativeId).collect(Collectors.toSet());
        if(!checkCreativeExsist(creativeIds)){
            throw new GlobalException(CodeMsg.EXSIST_NO_CREATIVE_IDS) ;
        }
        List<Long> list = adCreativeUnitRepository.saveAll(creativeUnits).stream().map(CreativeUnit::getId).collect(Collectors.toList()) ;
        return list ;
    }

    private boolean checkUnitExsist(Set<Long> ids){
        if(ids == null || ids.isEmpty()){
            return true;
        }
        return adUnitRepository.exsists(ids) == ids.size() ;
    }

    private boolean checkCreativeExsist(Set<Long> ids){
        if(ids == null || ids.isEmpty()){
            return true ;
        }
        return adCreativeRepository.exsits(ids) == ids.size() ;
    }


}

