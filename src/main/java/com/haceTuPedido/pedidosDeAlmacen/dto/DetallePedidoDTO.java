package com.haceTuPedido.pedidosDeAlmacen.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDTO {
    private Long productoId;
    private String nombreProducto;
    private double precioUnitario;
    private Integer cantidad;
    private double subtotal;

}
