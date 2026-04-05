package com.haceTuPedido.pedidosDeAlmacen.repository;

import com.haceTuPedido.pedidosDeAlmacen.model.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio,Long> {
}
