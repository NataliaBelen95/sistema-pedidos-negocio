package com.haceTuPedido.pedidosDeAlmacen.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NegocioDTO {
    private Long id;
    private String nombre;
    private List<PedidoDTO> pedidos;
    private String direccion;


}
