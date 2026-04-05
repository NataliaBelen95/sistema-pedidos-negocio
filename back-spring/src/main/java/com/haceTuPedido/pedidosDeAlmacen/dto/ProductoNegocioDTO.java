package com.haceTuPedido.pedidosDeAlmacen.dto;


import com.haceTuPedido.pedidosDeAlmacen.enums.EnumUnidadMedida;
import com.haceTuPedido.pedidosDeAlmacen.model.Producto;
import lombok.*;

import java.util.List;
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductoNegocioDTO {
    private Long idProductoNegocio;
    private int stock;
    private double precioVenta;

    private Long idNegocio;
    private Long idProducto;



}
