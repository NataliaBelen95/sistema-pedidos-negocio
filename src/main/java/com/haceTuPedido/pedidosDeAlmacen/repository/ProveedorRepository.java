package com.haceTuPedido.pedidosDeAlmacen.repository;

import com.haceTuPedido.pedidosDeAlmacen.enums.EnumCategoria;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {
    List<Proveedor> findByNombre(String nombre);
}
