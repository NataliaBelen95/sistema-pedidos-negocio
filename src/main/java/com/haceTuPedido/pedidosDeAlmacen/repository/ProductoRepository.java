package com.haceTuPedido.pedidosDeAlmacen.repository;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    List<Producto> findByCategoriaNombre(EnumCategoria nombre);

}
