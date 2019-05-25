package com.fei.adsponsor.repository;

import com.fei.adsponsor.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    AdUser findByUsername(String username);

}
