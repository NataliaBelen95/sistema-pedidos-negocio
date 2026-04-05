package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.Negocio;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface INegocioService {
    List<NegocioDTO> traerNegocios();
    NegocioDTO crearnegocio(NegocioDTO negocioDTO);
    NegocioDTO actualizarNegocio(Long id, NegocioDTO negocioDTO);
    void eliminarNegocio(Long id);
}
