package com.haceTuPedido.pedidosDeAlmacen.controller;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.service.IProductoProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos-proveedores")
public class ProductoProveedorController {

    @Autowired
    private IProductoProveedorService service;

    // El que acabás de crear: ¿Quién vende la Yerba y a qué precio?
    @GetMapping("/precios-producto/{idProducto}")
    public ResponseEntity<List<ProductoProveedorDTO>> traerPrecios(@PathVariable Long idProducto) {
        return ResponseEntity.ok(service.traerPrecioDelProductoConSuProveedor(idProducto));
    }

    // Para cargar un precio nuevo (el ABM)
    @PostMapping("/asignar")
    public ResponseEntity<ProductoProveedorDTO> asignar(@RequestBody ProductoProveedorDTO dto) {
        return ResponseEntity.ok(service.asignarProductoAProveedor(dto));
    }
}