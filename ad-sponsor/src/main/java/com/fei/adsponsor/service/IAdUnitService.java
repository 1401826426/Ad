package com.fei.adsponsor.service;

import com.fei.adsponsor.entity.AdUnit;
import com.fei.adsponsor.entity.CreativeUnit;
import com.fei.adsponsor.entity.unit_condition.AdUnitDistrict;
import com.fei.adsponsor.entity.unit_condition.AdUnitIt;
import com.fei.adsponsor.entity.unit_condition.AdUnitKeyword;

import java.util.List;

public interface IAdUnitService {

    AdUnit create(AdUnit adUnit) ;

    List<Long> createUnitIts(List<AdUnitIt> adUnits) ;

    List<Long> createUnitKeywords(List<AdUnitKeyword> adUnitKeywords) ;

    List<Long> createUnitDistrict(List<AdUnitDistrict> adUnitDistricts) ;

    List<Long> createCreativeUnit(List<CreativeUnit> creativeUnits) ;

}
