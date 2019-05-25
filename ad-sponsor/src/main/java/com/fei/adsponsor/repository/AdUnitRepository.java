package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.AdUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {
}
