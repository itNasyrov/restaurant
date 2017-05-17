package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Document;

import java.util.List;

public interface DocumentService {

    /**
     * Create document in DB
     * @param document - document for creation
     * @return document
     */
    Document addDocument(Document document);

    /**
     * Recieve all document
     * @return all documents from DB
     */
    List<Document> getDocumentList();

    /**
     * delete document with id
     * @param id - document id
     * @return document
     */
    Document deleteDocument(long id);

    /**
     * get document by id
     * @param id
     * @return document
     */
    Document getDocumentById(long id);

    /**
     * update document
     * @param document for update
     * @return document
     */
    Document updateDocument(Document document);

    /**
     * find document list by name
     * @param name
     * @return List of documents
     */
    List<Document> getDocumentListByName(String name);
}
