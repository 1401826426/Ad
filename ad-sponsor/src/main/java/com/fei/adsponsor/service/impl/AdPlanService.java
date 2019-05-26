package com.fei.adsponsor.service.impl;

import com.fei.adsponsor.constants.PlanStatus;
import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.repository.AdPlanRepository;
import com.fei.adsponsor.service.IAdPlanService;
import com.fei.common.CodeMsg;
import com.fei.common.exception.GlobalException;
import com.fei.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdPlanService implements IAdPlanService {

    @Autowired
    private AdPlanRepository adPlanRepository ;

    @Override
    @Transactional
    public AdPlan create(AdPlan adPlan, long userId) {
        if(StringUtils.isBlank(adPlan.getPlanName())){
            throw new GlobalException(CodeMsg.NO_PLAN_NAME) ;
        }
        if(adPlan.getStartDate() == null || adPlan.getEndDate() == null){
            throw new GlobalException(CodeMsg.ERROR_DATE) ;
        }
        AdPlan oldPlan = adPlanRepository.findByPlanName(adPlan.getPlanName()) ;
        if(oldPlan != null){
            throw new GlobalException(CodeMsg.HAS_PLAN);
        }
        adPlan.setUserId(userId);
        adPlan.setCreateTime(new Date());
        adPlan.setUpdateTime(new Date());
        adPlan.setPlanStatus(PlanStatus.VALID.getStatus());
        adPlanRepository.save(adPlan) ;
        return adPlan;
    }

    @Override
    @Transactional
    public AdPlan update(AdPlan adPlan,long userId) {
        if(adPlan.getStartDate() == null || adPlan.getEndDate() == null){
            throw new GlobalException(CodeMsg.ERROR_DATE) ;
        }
        if(adPlan.getStartDate().after(adPlan.getEndDate())){
            throw new GlobalException(CodeMsg.ERROR_DATE) ;
        }
        if(adPlan.getId() <= 0){
            throw new GlobalException(CodeMsg.NO_PLAN_ID) ;
        }
        Optional<AdPlan> optional = adPlanRepository.findById(adPlan.getId()) ;
        if(!optional.isPresent()){
            throw new GlobalException(CodeMsg.NO_PLAN);
        }
        AdPlan dbAdPlan = optional.get() ;
        if(dbAdPlan.getUserId() != userId){
            throw new GlobalException(CodeMsg.HAS_NO_RULE);
        }
        if(adPlan.getStartDate() != null){
            dbAdPlan.setStartDate(adPlan.getStartDate());
        }
        if(adPlan.getEndDate() != null){
            dbAdPlan.setEndDate(adPlan.getEndDate());
        }
        if(!StringUtils.isBlank(adPlan.getPlanName())){
            dbAdPlan.setPlanName(adPlan.getPlanName());
        }

        dbAdPlan.setUpdateTime(new Date());
        adPlanRepository.save(dbAdPlan) ;
        return dbAdPlan;
    }

    @Override
    @Transactional
    public boolean delete(long id,long userId) {
        Optional<AdPlan> optional = adPlanRepository.findById(id) ;
        if(!optional.isPresent()){
            return false ;
        }
        AdPlan plan = optional.get() ;
        if(plan.getUserId() != userId){
            throw new GlobalException(CodeMsg.HAS_NO_RULE);
        }
        adPlanRepository.deleteById(id);
        return true ;
    }

    @Override
    public List<AdPlan> findByUserId(long userId) {
        List<AdPlan> adPlans = adPlanRepository.findAllByUserId(userId) ;
        return adPlans;
    }
}
