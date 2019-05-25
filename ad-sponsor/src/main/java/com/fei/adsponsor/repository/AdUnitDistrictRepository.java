package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdPlan;
import com.fei.adsponsor.entity.unit_condition.AdUnitDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUnitDistrictRepository extends JpaRepository<AdUnitDistrict,Long> {
}
