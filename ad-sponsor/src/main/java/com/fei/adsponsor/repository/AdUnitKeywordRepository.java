package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.unit_condition.AdUnitKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUnitKeywordRepository extends JpaRepository<AdUnitKeyword,Long> {
}
