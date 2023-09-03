package com.example.onetomany.service;

import com.example.onetomany.model.Kommune;
import com.example.onetomany.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner
{
    private RestTemplate restTemplate;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Autowired
    KommuneRepository KommuneRepository;

    String KommuneUrl = "https://api.dataforsyningen.dk/kommuner";


    private void saveKommuner(List<Kommune> Kommuner)
    {
        Kommuner.forEach(reg -> KommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner()
    {
        ResponseEntity<List<Kommune>> KommuneResponse =
                restTemplate.exchange(KommuneUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>() {
                        });
        List<Kommune> Kommuner = KommuneResponse.getBody();
        saveKommuner(Kommuner);
        return Kommuner;
    }
}
