package com.haceTuPedido.pedidosDeAlmacen.controller;

import com.haceTuPedido.pedidosDeAlmacen.dto.CategoriaDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.service.ICategoriaService;
import com.haceTuPedido.pedidosDeAlmacen.service.INegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {


    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> traerCategorias() {
        return ResponseEntity.ok(categoriaService.traerCategorias());

    }


}
