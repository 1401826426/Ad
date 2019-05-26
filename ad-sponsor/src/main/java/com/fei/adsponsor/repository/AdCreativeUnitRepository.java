package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.CreativeUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCreativeUnitRepository extends JpaRepository<CreativeUnit,Long> {
}
