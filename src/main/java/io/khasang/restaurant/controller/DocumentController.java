package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.service.DocumentService;
import io.khasang.restaurant.util.ResponseRestFactory;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import restaurant.swagger.api.DocumentApi;
import restaurant.swagger.model.ResponseRest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DocumentController implements DocumentApi {
    @Autowired
    private DocumentService documentService;

    public ResponseEntity<ResponseRest> addDocumentUsingPUT(@ApiParam(value = "document" ,required=true )
                                                            @Valid @RequestBody restaurant.swagger.model.Document document) {
        Document entity = documentService.addDocument(documentToEntity(document));
        restaurant.swagger.model.Document body = entityToDocument(entity);
        return ResponseEntity.ok(ResponseRestFactory.success(body));
    }

    public ResponseEntity<ResponseRest> deleteDocumentUsingDELETE(@ApiParam(value = "id",required=true )
                                                                  @PathVariable("id") String id) {
        Document entity = documentService.deleteDocument(Long.parseLong(id));
        restaurant.swagger.model.Document body = entityToDocument(entity);
        return ResponseEntity.ok(ResponseRestFactory.success(body));
    }

    public ResponseEntity<ResponseRest> getDocumentByIdUsingGET(@ApiParam(value = "id",required=true )
                                                                @PathVariable("id") String id) {
        Document entity = documentService.getDocumentById(Long.parseLong(id));
        if (entity == null)
            return ResponseEntity.ok(ResponseRestFactory.notFound("DocumentNotFound with id = " + id));

        restaurant.swagger.model.Document body = entityToDocument(entity);
        return ResponseEntity.ok(ResponseRestFactory.success(body));
    }

    public ResponseEntity<List<restaurant.swagger.model.Document>> getDocumentListByNameUsingGET(@ApiParam(value = "name",required=true )
                                                                            @PathVariable("name") String name) {
        List<Document> list = documentService.getDocumentListByName(name);
        List<restaurant.swagger.model.Document> documents = new ArrayList<>();
        list.forEach(d -> documents.add(entityToDocument(d)));
        return ResponseEntity.ok(documents);
    }

    public ResponseEntity<List<restaurant.swagger.model.Document>> getDocumentListUsingGET() {
        List<Document> list = documentService.getDocumentList();
        List<restaurant.swagger.model.Document> documents = new ArrayList<>();
        list.forEach(d -> documents.add(entityToDocument(d)));
        return ResponseEntity.ok(documents);
    }

    public ResponseEntity<ResponseRest> updateDocumentUsingPUT(@ApiParam(value = "document" ,required=true )
                                                               @Valid @RequestBody restaurant.swagger.model.Document document) {
        Document entity = documentService.updateDocument(documentToEntity(document));
        restaurant.swagger.model.Document body = entityToDocument(entity);
        return ResponseEntity.ok(ResponseRestFactory.success(body));
    }

    private Document documentToEntity(restaurant.swagger.model.Document document) {
        Document entity = new Document();

        if (document.getId() != null)
            entity.setId(document.getId());
        entity.setName(document.getName());
        entity.setDescription(document.getDescription());
        entity.setDocumentItems(new ArrayList<>());
        return entity;
    }

    private restaurant.swagger.model.Document entityToDocument(Document entity) {
        restaurant.swagger.model.Document document = new restaurant.swagger.model.Document();
        document.setId(entity.getId());
        document.setName(entity.getName());
        document.setDescription(entity.getDescription());
        document.setDocumentItems(new ArrayList<>());
        return document;
    }
}
