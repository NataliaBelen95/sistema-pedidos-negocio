package com.haceTuPedido.pedidosDeAlmacen.controller;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import com.haceTuPedido.pedidosDeAlmacen.service.IProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());

    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO productoDTO){
       ProductoDTO productoCreado=  productoService.crearProducto(productoDTO);
        return ResponseEntity.created(URI.create("/api/productos" + productoCreado.getId())).body(productoCreado);
    }


    @PutMapping ("/{id}")
    public ResponseEntity<ProductoDTO> editarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.ok(productoService.editarProducto(id, productoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoDTO> eliminarProducto(@PathVariable Long id){
    productoService.eliminarProducto(id);
    return ResponseEntity.noContent().build();
    }

    //traer producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> traerProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.encontrarProductoPorId(id));

    }

    /*traer por categoria nombre*/
    @GetMapping("/categoria/{nombreCategoria}")
    public ResponseEntity<List<ProductoDTO>> traerPorCategoria(@PathVariable String nombreCategoria) {
        EnumCategoria categoriaEnum = EnumCategoria.valueOf(nombreCategoria.toUpperCase());
        return ResponseEntity.ok(productoService.encontrarPorCategoria(categoriaEnum));

    }


}
