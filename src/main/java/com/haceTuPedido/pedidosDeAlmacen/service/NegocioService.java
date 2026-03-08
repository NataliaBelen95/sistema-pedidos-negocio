package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.NegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Negocio;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.repository.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NegocioService implements INegocioService {

    @Autowired
    private NegocioRepository repo;


    @Override
    public List<NegocioDTO> traerNegocios() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public NegocioDTO crearnegocio(NegocioDTO negocioDTO) {
       Negocio negocio = Negocio.builder()
                .nombre(negocioDTO.getNombre())
                .direccion (negocioDTO.getDireccion())
                .build();
        return Mapper.toDTO(repo.save(negocio));
    }

    @Override
    public NegocioDTO actualizarNegocio(Long id, NegocioDTO negocioDTO) {
        return null;
    }

    @Override
    public void eliminarNegocio(Long id) {

    }
}
