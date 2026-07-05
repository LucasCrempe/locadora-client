package com.cliente.locadora.services;

import com.cliente.locadora.models.Locadora;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class LocadoraService {

    private final RestClient restClient;

    public LocadoraService() {
        this.restClient = RestClient.create("http://localhost:8080/locadoras");
    }

    public List<Locadora> findAll() {
        return restClient.get()
                .retrieve()
                .body(new ParameterizedTypeReference<List<Locadora>>() {});
    }

    public Locadora findById(Long id) {
        return restClient.get()
                .uri("/{id}", id)
                .retrieve()
                .body(Locadora.class);
    }

    public void save(Locadora locadora) {
        if (locadora.getId() == null) {
            restClient.post()
                    .body(locadora)
                    .retrieve()
                    .toBodilessEntity();
        } else {
            restClient.put()
                    .uri("/{id}", locadora.getId())
                    .body(locadora)
                    .retrieve()
                    .toBodilessEntity();
        }
    }

    public void delete(Long id) {
        restClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .toBodilessEntity();
    }
}