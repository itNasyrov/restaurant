package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Document;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class DocumentControllerIntegrationTest {

    private final String ROOT = "http://localhost:8081/document";
    private final String ADD = ROOT + "/add";
    private final String GET_ID = ROOT + "/get/id/";
    private final String UPDATE = ROOT + "/update";
    private final String DELETE = ROOT + "/delete/";
    private final String ALL = ROOT + "/all";

    @Test
    public void addDocument() {
        Document document = createDocument("Fireball");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );
        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Document result = responseEntity.getBody();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), "Fireball");
    }

    @Test
    public void updateDocument() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Document document = createDocument("Not updated");
        document.setName("Updated");
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        Document resultUpdated = restTemplate.exchange(
                UPDATE,
                HttpMethod.POST,
                httpEntity,
                Document.class).getBody();

        Assert.assertNotNull(resultUpdated);
        Assert.assertNotNull(resultUpdated.getId());
        Assert.assertEquals("Updated", resultUpdated.getName());
    }

    @Test
    public void deleteDocument() {
        Document document = createDocument("For delete");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                Document.class,
                document.getId()
        );
        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Document> checkDocumentExist = restTemplate.exchange(
                GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );
        Assert.assertNull(checkDocumentExist.getBody());
    }

    @Test
    public void getAllDocuments() {
        createDocument("First document");
        createDocument("Second document");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {}
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Assert.assertNotNull(responseEntity.getBody());

    }

    private Document createDocument(String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Document document = documentPrefill(name);
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate restTemplate = new RestTemplate();
        Document result = restTemplate.exchange(
                ADD,
                HttpMethod.PUT,
                httpEntity,
                Document.class).getBody();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), name);
        Assert.assertNotNull(result.getId());
        return result;
    }

    private Document documentPrefill(String name) {
        Document document = new Document();
        document.setName(name);
        return document;
    }
}
