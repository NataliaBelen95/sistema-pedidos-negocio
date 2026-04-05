package com.haceTuPedido.pedidosDeAlmacen.controller;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.service.IProductoNegocioService;
import com.haceTuPedido.pedidosDeAlmacen.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/negocio/productos")
public class ProductoNegocioController {


    @Autowired
    private IProductoNegocioService productoNegocioService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductoNegocioDTO> traerProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoNegocioService.findById(id));

    }
}
