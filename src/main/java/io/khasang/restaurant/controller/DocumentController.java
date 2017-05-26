package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.servise.DocumentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentServise documentServise;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Document addDocument(@RequestBody Document document){
        return documentServise.addDocument(document);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentList(){
        return documentServise.getDocumentList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Document deleteCompany(@PathVariable(value = "id") String id){
        return documentServise.deleteDocument(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Document updateDocument(@RequestBody Document document){
        documentServise.updateDocument(document);
        return document;
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Document getDocumentById(@PathVariable(value = "id") String id){
        return documentServise.getDocumentById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentListByName(@PathVariable(value = "name") String name){
        return documentServise.getDocumentListByName(name);
    }
}
