package com.example.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.service.ApiService;

@RestController
@RequestMapping("/productos/")

public class ApiController {
    @Autowired
    ApiService servicio;
    @GetMapping("/")
    public String hello(){
        return servicio.hola();
      
    }
    @GetMapping("/nombre")
    public String getMethodName(@RequestParam String name){
        return new String();
    }
    @PostMapping("/")
    public String guardar(@RequestBody String body){
        return servicio.guardar(body);
    }
    @PutMapping("/{id}")
    public String actualizar(@PathVariable String id, @RequestBody String ently){
        return servicio.actualizar(id, ently);
    }
    @DeleteMapping("/{id}")
    public String borrar(@PathVariable String id){
        return servicio.borrar();
}
}
