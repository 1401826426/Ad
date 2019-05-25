package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {
}
