package apirest.apirest.utils;

import apirest.apirest.models.UserModel;
import apirest.apirest.models.CompraVentaModel;

import apirest.apirest.models.VehiculoModel;

//Clase para devolver mensajes al usuario
public class ReponseMessage extends UserModel {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReponseMessage(String message) {
        this.message = message;
    }

    public ReponseMessage() {
    }
}

