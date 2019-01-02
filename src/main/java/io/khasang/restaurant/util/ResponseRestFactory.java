package io.khasang.restaurant.util;

import restaurant.swagger.model.ResponseRest;

public class ResponseRestFactory {
    /**
     * get success Response Rest
     *
     * @param body - object view
     * @return ResponseRest
     */
    public static ResponseRest success(Object body) {
        ResponseRest responseRest = new ResponseRest();
        responseRest.setCode(200);
        responseRest.setMessage("Ok");
        responseRest.setBody(body);
        return responseRest;
    }

    /**
     * get access denied Response Rest
     * @return ResponseRest
     */
    public static ResponseRest forbidden() {
        ResponseRest responseRest = new ResponseRest();
        responseRest.setCode(403);
        responseRest.setMessage("access denied");
        return responseRest;
    }

    /**
     * get not found Response Rest
     * @return ResponseRest
     */
    public static ResponseRest notFound(String message) {
        ResponseRest responseRest = new ResponseRest();
        responseRest.setCode(404);
        responseRest.setMessage("error: " + message);
        return responseRest;
    }
}
