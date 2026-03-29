package com.haceTuPedido.pedidosDeAlmacen.service;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Negocio;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService implements IProveedorService {

    @Autowired
    private ProveedorRepository repo;

    @Override
    public List<ProveedorDTO> listarProveedores() {
        List<Proveedor> proveedores = repo.findAll();
        return proveedores.stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public ProveedorDTO crearProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = Proveedor.builder()
                .nombre(proveedorDTO.getNombre())
                .cuit(proveedorDTO.getCuit())
                .build();
        return Mapper.toDTO(repo.save(proveedor));
    }

    @Override
    public ProveedorDTO actualizarProveedor(Long id, ProveedorDTO proveedorDTO) {
        Proveedor p = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("negocio no encontrado"));

        p.setNombre(proveedorDTO.getNombre());
        p.setCuit(proveedorDTO.getCuit());
        return Mapper.toDTO(repo.save(p));
    }

    @Override
    public void eliminarProveedor(Long id) {

    }

    @Override
    public ProveedorDTO encontrarProveedorPorId(Long id) {
        return null;
    }

    @Override
    public List <ProveedorDTO> encontrarProveedorPorNombre(String nombre) {
        return repo.findByNombre(nombre) //
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }
}
