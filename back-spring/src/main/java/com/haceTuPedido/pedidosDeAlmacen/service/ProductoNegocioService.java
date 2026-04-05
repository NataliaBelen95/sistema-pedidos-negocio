package com.haceTuPedido.pedidosDeAlmacen.service;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoNegocio;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoNegocioRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoNegocioService implements IProductoNegocioService {

    @Autowired
    ProductoNegocioRepository repo;

    @Override
    public ProductoNegocioDTO findById(Long idProductoNegocio) {
        ProductoNegocio pn = repo.findById(idProductoNegocio)
                .orElseThrow(() -> new NotFoundException("producto no encontrado"));
        return Mapper.toDTO(pn);
    }

    @Override
    public ProductoNegocioDTO obtenerStockPorProducto(Long idProducto) {
        return repo.findByProductoId(idProducto)
                .orElse(ProductoNegocioDTO.builder()
                        .idProducto(idProducto)
                        .stock(0)
                        .build());
    }
}
