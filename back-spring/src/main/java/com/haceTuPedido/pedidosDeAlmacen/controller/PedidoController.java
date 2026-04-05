package com.haceTuPedido.pedidosDeAlmacen.controller;

import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.PedidoDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.Pedido;
import com.haceTuPedido.pedidosDeAlmacen.service.INegocioService;
import com.haceTuPedido.pedidosDeAlmacen.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> traerPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());

    }




    @PostMapping
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoCreado = pedidoService.crearPedido(pedidoDTO);
        return ResponseEntity.created(URI.create("/api/productos" + pedidoCreado.getId())).body(pedidoCreado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> editarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return ResponseEntity.ok(pedidoService.editarPedido(id, pedidoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PedidoDTO> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    //traer pedidos por negocio filtro
    @GetMapping("/{id}")
    public ResponseEntity<List<PedidoDTO>> listarPedidosPorNegocio(@PathVariable Long id)  {
        return ResponseEntity.ok(pedidoService.listarPedidosPorNegocio(id));
    }
}
