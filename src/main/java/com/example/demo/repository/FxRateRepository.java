package com.example.demo.repository;


import com.example.demo.entity.FxRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FxRateRepository extends JpaRepository<FxRateEntity, Long> {
}

