package fr.univ.tp.servicecours.service;

import fr.univ.tp.servicecours.dto.EtudiantDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EtudiantClient {
    private final RestTemplate rest = new RestTemplate();

    @Value("${etudiants.url:http://localhost:8081/etudiants}")
    private String baseUrl;

    public EtudiantDto getEtudiantById(int id) {
        return rest.getForObject(baseUrl + "/" + id, EtudiantDto.class);
    }
}