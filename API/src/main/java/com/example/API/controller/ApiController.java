package com.example.API.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API.model.Producto;

 import com.example.API.service.ApiService;
@CrossOrigin( "*") 
@RestController
@RequestMapping("/productos/")

public class ApiController {
   @Autowired
 ApiService service;
 //Constructor de la clase para inyectar el servicio
 public ApiController(ApiService service) {
 this.service = service;
 }
 // CREATE
 @PostMapping ("/")
 public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
 Producto creado = service.crear(producto);
 return ResponseEntity
 .status(HttpStatus.CREATED)
 .body(creado);
 }
 // READ 
 @GetMapping ("/")
 public List<Producto> listar() {
 return service.listar();
 }


 @GetMapping("/{id}")
 public Producto buscar(@PathVariable int id) {
 return service.buscarPorId(id);
 }
 // UPDATE
 @PutMapping("/{id}")
 public Producto actualizar(
 @PathVariable int id,
 @RequestBody Producto producto) {

 return service.actualizar(id, producto);
 }
 // DELETE
 @DeleteMapping("/{id}")
 public String eliminar(@PathVariable int id) {
 return service.eliminar(id);
 }

}

