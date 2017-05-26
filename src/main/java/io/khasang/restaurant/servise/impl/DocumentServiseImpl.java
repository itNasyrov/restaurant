package io.khasang.restaurant.servise.impl;

import io.khasang.restaurant.dao.DocumentDao;
import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.servise.DocumentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("documentService")
public class DocumentServiseImpl implements DocumentServise{
    @Autowired
    DocumentDao documentDao;

    @Override
    public Document addDocument(Document document) {
        return documentDao.create(document);
    }

    @Override
    public List<Document> getDocumentList() {
        return documentDao.getList();
    }

    @Override
    public Document deleteDocument(long id) {
        return documentDao.delete(getDocumentById(id));
    }

    @Override
    public Document getDocumentById(long id) {
        return documentDao.getById(id);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentDao.update(document);
    }

    @Override
    public List<Document> getDocumentListByName(String name) {
        return documentDao.findByName(name);
    }
}
