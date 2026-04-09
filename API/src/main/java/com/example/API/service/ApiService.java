package com.example.API.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    public String hola(){
        return "Hola Mundo";
    }
    public String guardar(String body){
        return body;
    }
    public String actualizar(String id, String ently){
        return " 'id':" + id + ", 'ently':" + ently;
    }
    public String borrar(){
        return "Producto borrado";
    }
}
