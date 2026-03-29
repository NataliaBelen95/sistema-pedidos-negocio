package com.haceTuPedido.pedidosDeAlmacen.controller;


import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import com.haceTuPedido.pedidosDeAlmacen.service.INegocioService;
import com.haceTuPedido.pedidosDeAlmacen.service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private IProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO>> traerProveedores() {
        return ResponseEntity.ok(proveedorService.listarProveedores());

    }

    @PostMapping
    public ResponseEntity<ProveedorDTO> crearProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorDTO proveedorCreado = proveedorService.crearProveedor(proveedorDTO);
        return ResponseEntity.created(URI.create("/api/proveedores" + proveedorCreado.getId())).body(proveedorCreado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorDTO) {
        return ResponseEntity.ok(proveedorService.actualizarProveedor(id, proveedorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProveedorDTO> eliminarproveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }

}