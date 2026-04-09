package com.example.API.model;

public class Producto {
 private int id;
 private String name;
 private double precio;
 private String imagen;
 public Producto() {}
 public Producto(int id, String name,
double precio,String imagen) {
 this.id = id;
 this.name = name;
 this.precio=precio;
 this.imagen=imagen;
 }
 public int getId() {
    return id;
 }
 public void setId(int id) {
    this.id = id;
 }
 public String getName() {
    return name;
 }
 public void setName(String name) {
    this.name = name;
 }
 public double getPrecio() {
    return precio;
 }
 public void setPrecio(double precio) {
    this.precio = precio;
 }
 public String getImagen() {
    return imagen;
 }
 public void setImagen(String imagen) {
    this.imagen = imagen;
 }
 
}