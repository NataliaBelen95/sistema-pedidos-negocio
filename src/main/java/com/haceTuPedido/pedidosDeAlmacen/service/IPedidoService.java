package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.PedidoDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.EstadoPedido;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IPedidoService {
    List<PedidoDTO> listarPedidos();
    PedidoDTO crearPedido(PedidoDTO pedidoDTO);
    PedidoDTO editarPedido(Long id, PedidoDTO pedidoDto);

    void eliminarPedido(Long id);

    //BucarPedidosporNegocio
    List<PedidoDTO> listarPedidosPorNegocio(Long NegocioId);
    //editar solo estado
    PedidoDTO editarEstadopedido(Long id, EstadoPedido estadoPedido);
}

