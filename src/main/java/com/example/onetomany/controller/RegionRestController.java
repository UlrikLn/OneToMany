package com.example.onetomany.controller;

import com.example.onetomany.model.Kommune;
import com.example.onetomany.model.Region;
import com.example.onetomany.repository.KommuneRepository;
import com.example.onetomany.repository.RegionRepository;
import com.example.onetomany.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController
{
    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner()
    {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<String> deleteRegion(@PathVariable String id)
    {
        Optional<Region> orgRegion = regionRepository.findById(id);
        if (orgRegion.isPresent()){
            regionRepository.deleteById(id);
            return ResponseEntity.ok("Region with id=" + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region with id=" + id + " not found");
        }
    }

    @GetMapping("/regionKommune/{regionId}")
    public List<String> getCityNamesByRegionId(@PathVariable String regionId) {
        return kommuneRepository.findCityNamesByRegionId(regionId);
    }
}
