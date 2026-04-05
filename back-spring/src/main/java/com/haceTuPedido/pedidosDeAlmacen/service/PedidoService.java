package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.PedidoDTO;
import com.haceTuPedido.pedidosDeAlmacen.enums.EstadoPedido;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.*;
import com.haceTuPedido.pedidosDeAlmacen.repository.NegocioRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.PedidoRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    PedidoRepository repo;
    ProveedorRepository proveedorRepo;
    NegocioRepository negocioRepo;


    @Override
    public List<PedidoDTO> listarPedidos() {
        return repo.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public PedidoDTO crearPedido(PedidoDTO pedidoDTO) {

        if (pedidoDTO == null) {
            throw new RuntimeException("Pedido no puede ser nulo");
        }
        if (pedidoDTO.getNegocioId() == null) throw new RuntimeException("Negocio no puede ser nulo");
        if (pedidoDTO.getDetallesPedido() == null || pedidoDTO.getDetallesPedido().isEmpty())
            throw new RuntimeException("Debe incluir un pruducto");


        Proveedor proveedor = proveedorRepo.findById(pedidoDTO.getProveedorId()).orElse(null);
        if (proveedor == null) throw new RuntimeException("Proveedor no encontrado");

        Negocio negocio = negocioRepo.findById(pedidoDTO.getNegocioId()).orElse(null);
        if (negocio == null) throw new RuntimeException("Negocio no encontrado");


        Pedido pedido = new Pedido();
        pedido.setProveedor(proveedor);
        pedido.setNegocio(negocio);
        pedido.setFecha(LocalDate.now());
        pedido.setEstado(EstadoPedido.NO_ENVIADO);


        return Mapper.toDTO(repo.save(pedido));
    }

    @Override
    public PedidoDTO editarPedido(Long id, PedidoDTO pedidoDto) {
        Pedido pedido = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado"));



        return Mapper.toDTO(repo.save(pedido));
    }

    @Override
    public void eliminarPedido(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Pedido no encontrado");
        }
        repo.deleteById(id);

    }

    @Override
    public List<PedidoDTO> listarPedidosPorNegocio(Long negocioId) {
        return repo.findPedidosByNegocioId(negocioId);


    }

    @Override
    public PedidoDTO editarEstadopedido(Long id, EstadoPedido estadoPedido) {
        Pedido pedido = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado"));

        pedido.setEstado(estadoPedido);

        return Mapper.toDTO(repo.save(pedido));
    }

}
