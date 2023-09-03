package com.example.onetomany.repository;

import com.example.onetomany.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, String>
{
    @Query("SELECT k.navn FROM Kommune k WHERE k.region.kode = :regionId")
    List<String> findCityNamesByRegionId(String regionId);
}
