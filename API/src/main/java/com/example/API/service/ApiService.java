package com.example.API.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.API.model.Producto;

@Service
public class ApiService {
    private ArrayList<Producto> productos = new ArrayList<>();
 private int contadorId = 1;
 //CREATE
 public Producto crear(Producto producto) {
 producto.setId(contadorId++);
 productos.add(producto);
 return producto;
 }
 //READ - obtener todos
 public ArrayList<Producto> listar() {
 return productos;
 }
 //READ - obtener por id
 public Producto buscarPorId(int id) {
 // return productos.get(id);
 for(Producto p : productos){
 if(p.getId()==id) return p;
 }
 return null;
 }

 //UPDATE
 public Producto actualizar(int id, Producto productoActualizado) {
 Producto productoOptional = buscarPorId(id);
 int contador=0;
 if (productoOptional!=null) {
 for(Producto p : productos){
 if(p.getId()==id) productos.set(contador,productoActualizado);
 contador++;
 }
 }
 return null;
 }
 //DELETE
 public String eliminar(int id) {
 boolean encontrado=false;
 for (int i = 0; i < productos.size(); i++) {
 if (productos.get(i).getId() == id) {
 productos.remove(i); encontrado=true;
 }
 }
 return encontrado ? "Producto "+id+" eliminado":"Producto "+id+ " no encontrado";
 }

}
