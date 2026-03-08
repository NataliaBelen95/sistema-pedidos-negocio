package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> listarProductos();
    ProductoDTO crearProducto(ProductoDTO productoDto);
    ProductoDTO editarProducto(Long id, ProductoDTO productoDto);
    void eliminarProducto(Long id);
    ProductoDTO encontrarProductoPorId(Long id);
}
