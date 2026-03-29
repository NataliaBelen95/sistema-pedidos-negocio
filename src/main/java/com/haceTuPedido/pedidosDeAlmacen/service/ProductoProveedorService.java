package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoProveedor;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoProveedorRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoProveedorService implements IProductoProveedorService {

    @Autowired
    ProductoProveedorRepository repo;
    ProductoRepository productoRepo;
    ProveedorRepository proveedorRepo;

    @Override
    public List<ProductoProveedorDTO> traerProductosDelProveedor() {
        return repo.findAll().stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public ProductoProveedorDTO asignarProductoAProveedor(ProductoProveedorDTO productoProveedorDTO) {
        Producto prod = productoRepo.findById(productoProveedorDTO.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Proveedor prov = proveedorRepo.findById(productoProveedorDTO.getProveedorId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        //  relación con el precio
        ProductoProveedor relacion = new ProductoProveedor();
        relacion.setProducto(prod);
        relacion.setProveedor(prov);
        relacion.setPrecio(productoProveedorDTO.getPrecio());

        // se devuelve el DTO
        return Mapper.toDTO(repo.save(relacion));
    }
    }

