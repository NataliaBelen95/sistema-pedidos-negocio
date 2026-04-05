package com.haceTuPedido.pedidosDeAlmacen.repository;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor,Long> {

    List<ProductoProveedorDTO> findByProveedorId(Long proveedorId);
    List<ProductoProveedorDTO> findByProductoIdOrderByPrecioAsc(Long productoId);

}
