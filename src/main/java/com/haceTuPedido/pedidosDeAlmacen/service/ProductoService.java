package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.exception.NotFoundException;
import com.haceTuPedido.pedidosDeAlmacen.mapper.Mapper;
import com.haceTuPedido.pedidosDeAlmacen.model.Categoria;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.repository.CategoriaRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repo;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        Categoria categoria = categoriaRepository.findById(productoDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        var producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(categoria)
//                .precio(productoDto.getPrecio())
                .marca(productoDto.getMarca())
                .enumUnidadMedida(productoDto.getEnumUnidadMedida())
                .peso(productoDto.getPeso())
                .build();
        return Mapper.toDTO(repo.save(producto));
    }

    @Override
    public ProductoDTO editarProducto(Long id, ProductoDTO productoDto) {
        Categoria categoria = categoriaRepository.findById(productoDto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
           Producto p = repo.findById(id)
                   .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

           p.setNombre(productoDto.getNombre());
           p.setCategoria(categoria);
//           p.setPrecio(productoDto.getPrecio());
           p.setEnumUnidadMedida(productoDto.getEnumUnidadMedida());
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
