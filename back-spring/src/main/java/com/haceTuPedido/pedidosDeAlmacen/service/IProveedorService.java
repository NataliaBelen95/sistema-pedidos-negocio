package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProveedorService {

    List<ProveedorDTO> listarProveedores();
    ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO);
    ProveedorDTO actualizarProveedor(Long id, ProveedorDTO proveedorDTO);
    void eliminarProveedor(Long id);
    ProveedorDTO encontrarProveedorPorId(Long id);
    List <ProveedorDTO> encontrarProveedorPorNombre(String nombre);

}
