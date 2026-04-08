package com.haceTuPedido.pedidosDeAlmacen.service;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Negocio;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoNegocio;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import com.haceTuPedido.pedidosDeAlmacen.repository.NegocioRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoNegocioRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoNegocioService implements IProductoNegocioService {

    @Autowired
    ProductoNegocioRepository repo;

    @Autowired
    NegocioRepository repoNegocio;

    @Override
    public ProductoNegocioDTO findById(Long idProductoNegocio) {
        ProductoNegocio pn = repo.findById(idProductoNegocio)
                .orElseThrow(() -> new NotFoundException("producto no encontrado"));
        return Mapper.toDTO(pn);
    }

    @Override
    public ProductoNegocioDTO obtenerStockPorProducto(Long idProducto, Long idNegocio) {
        // 1. Buscamos el Negocio primero para tener su nombre SIEMPRE
        Negocio negocio = repoNegocio.findById(idNegocio)
                .orElseThrow(() -> new NotFoundException("Negocio no encontrado"));

        // 2. Buscamos la relación
        return repo.findByProductoIdAndNegocioId(idProducto, idNegocio)
                .map(Mapper::toDTO)
                .orElse(ProductoNegocioDTO.builder()
                        .idProducto(idProducto)
                        .idNegocio(idNegocio)
                        .nombreNegocio(negocio.getNombre())
                        .stock(0)
                        .nombreProducto("Cargar nombre de tabla Producto...")
                        .build());
    }
}
