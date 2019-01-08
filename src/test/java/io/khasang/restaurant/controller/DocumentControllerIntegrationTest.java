package io.khasang.restaurant.controller;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import restaurant.swagger.model.Document;
import restaurant.swagger.model.DocumentItem;
import restaurant.swagger.model.ResponseRest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@Ignore
public class DocumentControllerIntegrationTest {
    private final String ROOT = "http://localhost:8085/document";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";


    @Test
    public void addDocument() {
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseRest> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                ResponseRest.class,
                document.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Document resultDocument = mapToDocument((Map<String, Object>) responseEntity.getBody().getBody());
        assertNotNull(resultDocument);
        assertEquals(document.getDescription(), resultDocument.getDescription());
    }

    @Test
    public void updateDocument(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Document document =  createDocument();

        document.setName("IceArrow");
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);

        ResponseEntity<ResponseRest> resultUpdatedDocument = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                ResponseRest.class);

        Document document1 = mapToDocument((Map<String, Object>) resultUpdatedDocument.getBody().getBody());

        assertNotNull(resultUpdatedDocument.getBody());
        assertNotNull(document1.getId());
        assertEquals(document.getName(), document1.getName());
    }

    @Test
    public void deleteDocument(){
        Document document = createDocument();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseRest> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                ResponseRest.class,
                document.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<ResponseRest> checkDocumentExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                ResponseRest.class,
                document.getId()
        );

        assertNull(checkDocumentExist.getBody().getBody());
    }

    @Test
    public void getAllDocuments(){
        RestTemplate restTemplate = new RestTemplate();
        createDocument();
        createDocument();

        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Document createDocument() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Document document = documentPrefill();
        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseRest result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                ResponseRest.class).getBody();
        assertNotNull(result);

        Document resultDocument = mapToDocument((Map<String, Object>) result.getBody());

        assertEquals("Fireball", resultDocument.getName());
        assertNotNull(resultDocument.getId());
        return resultDocument;
    }

    private Document mapToDocument(Map<String, Object> map) {
        Document document = new Document();
        document.setId(Long.parseLong(map.get("id").toString()));
        document.setName(map.get("name").toString());
        document.setDescription(map.get("description").toString());
        return document;
    }

    private Document documentPrefill() {
        Document document = new Document();
        document.setName("Fireball");
        document.setDescription("Medium size");

        DocumentItem item = new DocumentItem();
        item.setName("2 mana");
        item.setPrice(new BigDecimal(BigInteger.valueOf(10)));


        DocumentItem item2 = new DocumentItem();
        item2.setName("3 mana");
        item2.setPrice(new BigDecimal(BigInteger.valueOf(6)));

        List<DocumentItem> documentItemList = new ArrayList<>();
        documentItemList.add(item);
        documentItemList.add(item2);

        document.setDocumentItems(documentItemList);

        return document;
    }


}
