package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.CategoriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {
   List<CategoriaDTO> traerCategorias();
}
