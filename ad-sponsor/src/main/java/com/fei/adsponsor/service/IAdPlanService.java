package com.fei.adsponsor.service;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.vo.UserDto;

import java.util.List;

public interface IAdPlanService {

     AdPlan create(AdPlan adPlan,long userId) ;

     AdPlan update(AdPlan adPlan,long userId) ;

     boolean delete(long id,long userId) ;

     List<AdPlan> findByUserId(long userId) ;


}
