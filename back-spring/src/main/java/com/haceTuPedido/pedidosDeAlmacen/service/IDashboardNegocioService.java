package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.DashboardProductoNegocioDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IDashboardNegocioService {
    List<DashboardProductoNegocioDTO> generarResumenComparativo(Long idNegocio, Long idProveedor);
    List<DashboardProductoNegocioDTO> obtenerProductosFaltantes(Long idNegocio);
}
