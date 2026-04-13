package com.example.API.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API.model.Producto;
import com.example.API.repository.ProductoRepository;

@Service
public class ApiService {
 @Autowired
 private ProductoRepository repository;
 //CREATE
 public Producto crear(Producto producto) {
 return repository.save(producto); // JPA asigna ID automáticamente
 }
 //READ - obtener todos
 public List<Producto> listar() {
 return repository.findAll();
 }
 //READ - obtener por id
 public Producto buscarPorId(long id) {
 return repository.findById(id).orElse(null);
 }

 //UPDATE
 public Producto actualizar(int id, Producto productoActualizado) {
 Producto existente = repository.findById((long) id).orElse(null);
 if (existente != null) {
 existente.setName(productoActualizado.getName());
 existente.setPrecio(productoActualizado.getPrecio());
 existente.setImagen(productoActualizado.getImagen());
 return repository.save(existente);
 }
 return null; // no existe
 }
 //DELETE
 public String eliminar(long id) {
 Producto existente = repository.findById(id).orElse(null);
 if (existente != null) {
 repository.deleteById(id);
 return "Producto " + id + " eliminado";
 }
 return "Producto " + id + " no encontrado";
 }
}