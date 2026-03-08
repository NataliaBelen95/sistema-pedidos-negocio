package com.haceTuPedido.pedidosDeAlmacen.dto;


import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProductoNegocioDTO {
    private Long idProductoNegocio;
    private int stock;
    private double precioVenta;

    private ProductoDTO productoDTO;

}
