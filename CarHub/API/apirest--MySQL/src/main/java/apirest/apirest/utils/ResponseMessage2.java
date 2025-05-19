package apirest.apirest.utils;

import apirest.apirest.models.CompraVentaModel;

import java.util.Date;

public class ResponseMessage2 extends CompraVentaModel {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseMessage2(String message) {
        this.message = message;
    }
}
