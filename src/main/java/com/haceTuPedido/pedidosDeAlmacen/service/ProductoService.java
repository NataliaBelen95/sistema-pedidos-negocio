package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> listarProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        var producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(productoDto.getCategoria())
//                .precio(productoDto.getPrecio())
                .unidadMedida(productoDto.getUnidadMedida())
                .peso(productoDto.getPeso())
                .build();
        return Mapper.toDTO(repo.save(producto));
    }

    @Override
    public ProductoDTO editarProducto(Long id, ProductoDTO productoDto) {
           Producto p = repo.findById(id)
                   .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

           p.setNombre(productoDto.getNombre());
           p.setCategoria(productoDto.getCategoria());
//           p.setPrecio(productoDto.getPrecio());
           p.setUnidadMedida(productoDto.getUnidadMedida());
           p.setPeso(productoDto.getPeso());

           return Mapper.toDTO(repo.save(p));


    }

    @Override
    public void eliminarProducto(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Producto no encontrado");
        }
               repo.deleteById(id);

    }

    @Override
    public ProductoDTO encontrarProductoPorId(Long id) {
        return repo.findById(id).map(Mapper::toDTO).orElse(null);
    }
}
