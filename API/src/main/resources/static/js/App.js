const API = "http://localhost:8080/productos";
//En este fichero vamos a hacer uso de incrustar HTML en la página index.html
function listarProductos() {
document.getElementById("formulario").style.display = "none";
//Hay que procesar la información que viene de la API
fetch(API).then(res => res.json()).then(data => {
let contenedor = document.getElementById("productos");
contenedor.innerHTML = "";
data.forEach(p => {
let imagen = p.imagen ? p.imagen : "https://placehold.co/300x200"; //Si no está la imagen pondrá una
contenedor.innerHTML += `
<div class="col-md-4 mb-4">
 <div class="card h-100">
 <img src="${imagen}" class="card-img-top img-card" alt="Imagen producto">
 <div class="card-body d-flex flex-column">
 <h5 class="card-title">${p.name}</h5>
 <p class="card-text">Precio: ${p.precio} €</p>
 <div class="mt-auto">
 <button class="btn btn-primary" onclick="editarProducto(${p.id}, '${p.name}', ${p.precio},'${p.imagen ?? ""}')">
Editar </button>
 <button class="btn btn-danger" onclick="eliminarProducto(${p.id})"> Eliminar </button>
 </div> </div> </div> </div>
`;}); }); }
function mostrarFormulario(){ //Formulario visible y limpiar los datos de entrada al acabar
document.getElementById("productos").innerHTML = "";
document.getElementById("formulario").style.display = "block";
// LIMPIAR FORMULARIO
document.getElementById("productoId").value = "";
document.getElementById("name").value = "";
document.getElementById("precio").value = "";
document.getElementById("imagen").value = "";}
function guardarProducto(){//Guardar el contenido del formulario ya sea nuevo o actualizar
let id = document.getElementById("productoId").value;
let name = document.getElementById("name").value;
let precio = document.getElementById("precio").value;
let imagen = document.getElementById("imagen").value;
let producto = { name: name, precio: precio, imagen: imagen }; //Hay que estructurar lo que mandarás a la API
if(id){ //Si hay id es porque estás haciendo update y hay que indicar la operación en el fetch
fetch(API + "/" + id,{method:"PUT",headers:{"Content-Type":"application/json"},body:JSON.stringify(producto)})
.then(()=>listarProductos());
}else{//Para crear una fila nueva hay que mandar el fetch con el método POST
fetch(API,{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(producto)})
.then(()=>listarProductos());}}
function editarProducto(id,name,precio,imagen){//Mostrar el formulario con los datos del producto
mostrarFormulario();
document.getElementById("productoId").value = id; document.getElementById("name").value = name;
document.getElementById("precio").value = precio; document.getElementById("imagen").value = imagen;}
function eliminarProducto(id){//Caso de eliminar el producto con el método DELETE
fetch(API + "/" + id,{method:"DELETE"})
.then(()=>listarProductos());}
//Al iniciar la web mostraremos los productos que haya
listarProductos();