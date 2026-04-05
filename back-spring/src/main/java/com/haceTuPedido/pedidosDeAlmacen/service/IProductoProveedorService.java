package com.haceTuPedido.pedidosDeAlmacen.service;


import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoDTO;
import com.haceTuPedido.pedidosDeAlmacen.dto.ProductoProveedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoProveedorService {
    List<ProductoProveedorDTO> traerProductosDelProveedor();
    ProductoProveedorDTO asignarProductoAProveedor(ProductoProveedorDTO productoProveedorDTO);

}
