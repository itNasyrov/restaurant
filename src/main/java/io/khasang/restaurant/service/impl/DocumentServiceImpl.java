package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.DocumentDao;

import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document addDocument(Document document) {
        return documentDao.create(document);
    }
}
