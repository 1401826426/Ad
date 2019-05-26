package com.fei.adsponsor.service.impl;

import com.fei.adsponsor.entity.AdCreative;
import com.fei.adsponsor.repository.AdCreativeRepository;
import com.fei.adsponsor.service.IAdCreativeService;
import com.fei.common.CodeMsg;
import com.fei.common.exception.GlobalException;
import com.fei.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdCreativeService implements IAdCreativeService {

    @Autowired
    private AdCreativeRepository adCreativeRepository ;

    @Override
    public AdCreative create(AdCreative creative,long userId) {
        if(StringUtils.isBlank(creative.getName())
             || StringUtils.isBlank(creative.getUrl())
             ){
            throw new GlobalException(CodeMsg.PARAMETER_ERROR) ;
        }
        AdCreative adCreative = adCreativeRepository.findByName(creative.getName()) ;
        if(adCreative != null){
            throw new GlobalException(CodeMsg.HAS_CREATIVE_NAME) ;
        }
        AdCreative dbCreative = new AdCreative(creative) ;
        dbCreative.setUserId(userId);
        adCreativeRepository.save(dbCreative) ;
        return dbCreative;
    }


}
