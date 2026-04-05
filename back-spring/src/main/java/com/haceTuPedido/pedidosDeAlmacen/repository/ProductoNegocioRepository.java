package com.haceTuPedido.pedidosDeAlmacen.repository;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoNegocioRepository extends JpaRepository<ProductoNegocio,Long> {
    // Para el Dashboard: Necesitamos la LISTA de todo lo que tiene el negocio
    List<ProductoNegocioDTO> findByNegocioId(Long idNegocio);

    // Para buscar un stock puntual
    Optional<ProductoNegocioDTO> findByProductoId(Long idProducto);
}
