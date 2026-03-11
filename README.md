# Sistema de Pedidos para Negocios

API backend desarrollada para facilitar a los negocios la gestión de pedidos a proveedores.  
La aplicación permite comparar precios entre distintos proveedores, administrar productos y realizar compras considerando el stock disponible, ayudando a optimizar el proceso de abastecimiento.

## Tecnologías

- Java
- Spring Boot
- PostgreSQL

## Endpoints

### Productos
GET /api/productos  
POST /api/productos  
PUT /api/productos/{id}  
DELETE /api/productos/{id}

### Negocios
GET /api/negocios  
POST /api/negocios  
PUT /api/negocios/{id}  
DELETE /api/negocios/{id}

### Proveedores
GET /api/proveedores  
POST /api/proveedores  
PUT /api/proveedores/{id}  
DELETE /api/proveedores/{id}

### Pedidos
GET /api/pedidos  
POST /api/pedidos  
PUT /api/pedidos/{id}  
DELETE /api/pedidos/{id}
