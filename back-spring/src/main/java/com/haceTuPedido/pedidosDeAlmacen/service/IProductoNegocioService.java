package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;

public interface IProductoNegocioService {
    ProductoNegocioDTO findById(Long idProductoNegocio);
    ProductoNegocioDTO obtenerStockPorProducto(Long idProducto, Long idNegocio);
}

