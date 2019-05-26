package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdCreative;
import com.fei.adsponsor.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AdCreativeRepository extends JpaRepository<AdCreative,Long> {

    AdCreative findByName(String name);

    @Query("select count(id) from ad_creative where id in ?1")
    int exsits(Set<Long> ids);
}
