package com.example.onetomany.controller;

import com.example.onetomany.model.Kommune;
import com.example.onetomany.model.Region;
import com.example.onetomany.service.ApiServiceGetKommuner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController
{
    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @GetMapping("/getkommuner")
    public List<Kommune> getKommuner()
    {
        List<Kommune> lstKommune = apiServiceGetKommuner.getKommuner();
        return lstKommune;
    }

}
