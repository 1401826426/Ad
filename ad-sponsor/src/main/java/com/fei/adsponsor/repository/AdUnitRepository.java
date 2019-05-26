package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    AdUnit findByPlanIdAndUnitName(long planId, String unitName);

    @Query("select count(id) from ad_unit where id in ?1")
    int exsists(Set<Long> ids);
}
