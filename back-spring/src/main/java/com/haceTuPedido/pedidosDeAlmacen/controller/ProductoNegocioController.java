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
@RequestMapping("/api/negocio-productos")
public class ProductoNegocioController {


    @Autowired
    private IProductoNegocioService productoNegocioService;

    @GetMapping("/detalle-producto/{idProductoNegocio}")
    public ResponseEntity<ProductoNegocioDTO> traerPorId(@PathVariable Long idProductoNegocio) {
        return ResponseEntity.ok(productoNegocioService.findById(idProductoNegocio));
    }
    @GetMapping("/{idNegocio}/{idProducto}/stock")
    public ResponseEntity<ProductoNegocioDTO> obtenerStock(@PathVariable Long idProducto, @PathVariable Long idNegocio) {
        return ResponseEntity.ok(productoNegocioService.obtenerStockPorProducto(idProducto, idNegocio));
    }

}
