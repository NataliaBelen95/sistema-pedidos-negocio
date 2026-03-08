package com.haceTuPedido.pedidosDeAlmacen.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PedidoDTO {
    private Long id;
    private LocalDate fecha;
    private String proveedorNombre;
    private String negocioNombre;
    private Long proveedorId;
    private Long NegocioId;
    private List<DetallePedidoDTO> detallesPedido;
    private double total;
}
