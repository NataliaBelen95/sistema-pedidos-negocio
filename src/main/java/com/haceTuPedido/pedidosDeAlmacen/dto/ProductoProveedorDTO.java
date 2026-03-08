package com.haceTuPedido.pedidosDeAlmacen.dto;

import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import com.haceTuPedido.pedidosDeAlmacen.model.Proveedor;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoProveedorDTO {

    private Long id;
    private Producto producto;
    private Proveedor proveedor;
    private double precio;

    private ProductoDTO productoDTO;


}
