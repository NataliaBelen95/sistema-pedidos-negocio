package com.haceTuPedido.pedidosDeAlmacen.service;

import com.haceTuPedido.pedidosDeAlmacen.dto.DashboardProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoNegocioDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoProveedorDTO;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoNegocio;
import com.haceTuPedido.pedidosDeAlmacen.model.ProductoProveedor;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoNegocioRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoProveedorRepository;
import com.haceTuPedido.pedidosDeAlmacen.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DashboardNegocioService implements IDashboardNegocioService{

    @Autowired
    private ProductoNegocioRepository productoNegocioRepo; // Tu tabla de stock
    @Autowired
    private ProductoProveedorRepository productoProveedorRepo; // La lista del proveedor
    @Autowired
    private ProductoRepository productoGeneralRepo;

    @Override
    public List<DashboardProductoNegocioDTO> generarResumenComparativo(Long idNegocio, Long idProveedor) {
        // 1. Asegurate que estos métodos en los Repos devuelvan lo que dice acá
        List<ProductoProveedorDTO> catalogoProveedor = productoProveedorRepo.findByProveedorId(idProveedor);
        List<ProductoNegocioDTO> inventarioLocal = productoNegocioRepo.findByNegocioId(idNegocio);

        return catalogoProveedor.stream().map(pp -> {
            // Buscamos coincidencia en el inventario local
            // Usamos una lambda (pn -> ...) que es más fácil de debugear que el ::
            Optional<ProductoNegocioDTO> miStockDto = inventarioLocal.stream()
                    .filter(pn -> pn.getIdProducto() != null && pn.getIdProducto().equals(pp.getProductoId()))
                    .findFirst();

            return DashboardProductoNegocioDTO.builder()
                    .idProducto(pp.getProductoId())
                    .nombre(pp.getNombreProducto())
                    .marca(pp.getMarca())
                    .precioCompraProveedor(pp.getPrecio())
                    .stockActual(miStockDto.map(dto -> dto.getStock()).orElse(0))
                    .loTrabajo(miStockDto.isPresent())
                    .idProductoNegocio(miStockDto.map(dto -> dto.getIdProductoNegocio()).orElse(null))
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<DashboardProductoNegocioDTO> obtenerProductosFaltantes(Long idNegocio) {
        return List.of();
    }
}
