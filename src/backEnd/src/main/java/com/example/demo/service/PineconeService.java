package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class PineconeService {

    @Value("${pinecone.api.key}")
    private String apiKey;

    @Value("${pinecone.host}")
    private String host;

    private RestTemplate restTemplate = new RestTemplate();

    public String queryPinecone(String queryText) {
        String url = host + "/query";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{ \"vector\": [" + queryText + "], \"topK\": 10 }";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public String getRecommendationsForTopic(String topic) {
        String url = host + "/recommendations";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{ \"topic\": \"" + topic + "\" }";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public void createIndex(String indexName, int dimension) {
        String url = host + "/indexes";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);
        headers.set("Content-Type", "application/json");

        String requestBody = "{ \"name\": \"" + indexName + "\", \"dimension\": " + dimension + ", \"metric\": \"cosine\" }";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());
    }

    public void upsertVectors(String indexName, String vectors) {
        String url = host + "/indexes/" + indexName + "/vectors";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Api-Key", apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(vectors, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println(response.getBody());
    }
}
