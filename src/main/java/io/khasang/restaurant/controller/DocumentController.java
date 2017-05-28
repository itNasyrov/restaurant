package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.exception.DocumentNotFoundException;
import io.khasang.restaurant.model.ExceptionJSONInfo;
import io.khasang.restaurant.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Document addDocument(@RequestBody Document document){
        return documentService.addDocument(document);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentList(){
        return documentService.getDocumentList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Document deleteDocument(@PathVariable(value = "id") String id){
        return documentService.deleteDocument(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Document updateDocument(@RequestBody Document document){
        documentService.updateDocument(document);
        return document;
    }

    /*
    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Document getDocumentById(@PathVariable(value = "id") String id){
        return documentService.getDocumentById(Long.parseLong(id));
    }
     */

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Document getDocumentById(@PathVariable(value = "id") String id) throws DocumentNotFoundException {
        Document booking = documentService.getDocumentById(Long.parseLong(id));
        if (booking == null) {
            throw new DocumentNotFoundException(id);
        }
        return booking;
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
        ExceptionJSONInfo response = new ExceptionJSONInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(ex.getMessage());
        //todo: LoggerFactory for logger.error
        return response;
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Document> getDocumentListByName(@PathVariable(value = "name") String name){
        return documentService.getDocumentListByName(name);
    }

}
