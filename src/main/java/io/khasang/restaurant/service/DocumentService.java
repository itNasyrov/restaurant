package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Document;

import java.util.List;

public interface DocumentService {

    /**
     * Create document in the database
     *
     * @param document - document to be created
     * @return document
     * */
    Document addDocument(Document document);

    /**
     * Get all documents
     *
     * @return all documents from database
     * */
    List<Document> getDocumentList();

    /**
     * Delete document by id;
     *
     * @param id - id of the document to be deleted
     * @return document deleted
     */
    Document deleteDocument(long id);

    /**
     * Get document by id
     *
     * @param id - id of the document
     * @return document
     */
    Document getDocumentById(long id);

}
