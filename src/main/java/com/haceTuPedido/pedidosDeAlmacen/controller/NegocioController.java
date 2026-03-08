package com.haceTuPedido.pedidosDeAlmacen.controller;

import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.service.INegocioService;
import com.haceTuPedido.pedidosDeAlmacen.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

public class NegocioController {

    @RestController
    @RequestMapping("/api/negocios")
    public class ProductoController {

        @Autowired
        private INegocioService negocioService;

        @GetMapping
        public ResponseEntity<List<NegocioDTO>> traerNegocios() {
            return ResponseEntity.ok(negocioService.traerNegocios());

        }

        @PostMapping
        public ResponseEntity<NegocioDTO> crearNegocio(@RequestBody NegocioDTO negocioDTO) {
            NegocioDTO negocioCreado = negocioService.crearnegocio(negocioDTO);
            return ResponseEntity.created(URI.create("/api/productos" + negocioCreado.getId())).body(negocioCreado);
        }


        @PostMapping("/id")
        public ResponseEntity<NegocioDTO> actualizarNegocio(@PathVariable Long id, @RequestBody NegocioDTO negocioDTO) {
            return ResponseEntity.ok(negocioService.actualizarNegocio(id, negocioDTO));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<NegocioDTO> eliminarNegocio(@PathVariable Long id) {
            negocioService.eliminarNegocio(id);
            return ResponseEntity.noContent().build();
        }
    }
}
